package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 수열과쿼리16_14428 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int m = Integer.parseInt(br.readLine());

        int[][] queries = new int[m][];
        for (int i = 0; i < m; i++) queries[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int pow = 2;
        while (pow / 2 < n) pow *= 2;

        Node[] roots = new Node[n];
        Node[] tree = new Node[pow];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, n - 1, 1));

        while (!q.isEmpty()) {
            Node node = q.poll();

            tree[node.ind] = node;

            if (node.from == node.to) {
                int i = node.from;

                roots[i] = node;
                node.min = arr[i];
                node.minInd = i;
                continue;
            }

            int mid = (node.from + node.to) / 2;

            q.add(new Node(node.from, mid, node.ind * 2));
            q.add(new Node(mid + 1, node.to, node.ind * 2 + 1));
        }

        q.addAll(Arrays.asList(roots));

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.ind == 1) break;

            Node parent = tree[node.ind / 2];

            if (node.min < parent.min) {
                parent.min = node.min;
                parent.minInd = node.minInd;
            } else if (node.min == parent.min) {
                parent.minInd = Math.min(node.minInd, parent.minInd);
            }

            parent.children--;

            if (parent.children == 0) q.add(parent);
        }

        for (int i = 0; i < m; i++) {
            int[] query = queries[i];

            if (query[0] == 1) {
                Node node = roots[query[1] - 1];
                node.min = query[2];

                node = tree[node.ind / 2];

                while (node != null) {
                    Node left = tree[node.ind * 2];
                    Node right = tree[node.ind * 2 + 1];

                    if (left.min < right.min) {
                        node.min = left.min;
                        node.minInd = left.minInd;
                    } else if (right.min < left.min) {
                        node.min = right.min;
                        node.minInd = right.minInd;
                    } else {
                        node.min = left.min;
                        node.minInd = Math.min(left.minInd, right.minInd);
                    }

                    node = tree[node.ind / 2];
                }
            } else {
                System.out.println(findMinInd(tree, query[1] - 1, query[2] - 1, 1)[1] + 1);
            }
        }
    }

    public static int[] findMinInd(Node[] tree, int from, int to, int ind) {

        Node node = tree[ind];

        if (from <= node.from && node.to <= to) return new int[]{node.min, node.minInd};

        if (node.to < from || to < node.from) return new int[]{Integer.MAX_VALUE, 0};

        int[] left = findMinInd(tree, from, to, ind * 2);
        int[] right = findMinInd(tree, from, to, ind * 2 + 1);

        if (left[0] < right[0]) return left;
        else if (right[0] < left[0]) return right;
        else if (left[1] < right[1]) return left;
        else return right;
    }

    public static class Node {
        int from;
        int to;
        int ind;

        int children = 2;

        int min = Integer.MAX_VALUE;
        int minInd = 0;

        public Node(int from, int to, int ind) {
            this.from = from;
            this.to = to;
            this.ind = ind;
        }
    }
}
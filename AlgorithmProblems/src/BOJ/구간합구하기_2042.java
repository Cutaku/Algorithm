package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 구간합구하기_2042 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nmk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nmk[0], m = nmk[1], k = nmk[2];

        int pow = 2;
        while (pow < n) pow *= 2;

        Node[] tree = new Node[pow * 2];
        Node[] roots = new Node[n];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, n - 1, 1));

        while (!q.isEmpty()) {
            Node node = q.poll();

            tree[node.ind] = node;

            if (node.from == node.to) {
                roots[node.from] = node;
                continue;
            }

            int mid = (node.from + node.to) / 2;

            q.add(new Node(node.from, mid, node.ind * 2));
            q.add(new Node(mid + 1, node.to, node.ind * 2 + 1));
        }

        for (Node node : roots) {
            node.sum = Long.parseLong(br.readLine());
        }

        q.addAll(Arrays.asList(roots));

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.ind == 1) break;

            Node parent = tree[node.ind / 2];

            parent.sum += node.sum;

            parent.children--;

            if (parent.children == 0) q.add(parent);
        }

        for (int i = 0; i < m + k; i++) {
            long[] order = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

            if (order[0] == 1) {
                Node node = roots[(int)order[1] - 1];

                long dif = order[2] - node.sum;

                while (node != null) {
                    node.sum += dif;

                    node = tree[node.ind / 2];
                }
            } else {
                System.out.println(findSum(tree, (int)order[1] - 1, (int)order[2] - 1, 1));
            }
        }
    }

    public static long findSum(Node[] tree, int from, int to, int ind) {

        Node node = tree[ind];

        if (from <= node.from && node.to <= to) {
            return node.sum;
        }

        if (to < node.from || node.to < from) return 0;

        return findSum(tree, from, to, ind * 2) + findSum(tree, from, to, ind * 2 + 1);
    }

    public static class Node {
        int from;
        int to;
        int ind;

        int children = 2;
        
        long sum = 0;

        public Node(int from, int to, int ind) {
            this.from = from;
            this.to = to;
            this.ind = ind;
        }
    }
}
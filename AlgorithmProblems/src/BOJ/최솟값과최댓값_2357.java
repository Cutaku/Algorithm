package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 최솟값과최댓값_2357 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        int pow = 2;
        while (n > pow) pow *= 2;

        Node[] roots = new Node[n];
        Node[] tree = new Node[pow * 2];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, n - 1, 1));

        while (!q.isEmpty()) {
            Node p = q.poll();

            tree[p.ind] = p;

            if (p.from == p.to) {
                roots[p.from] = p;
                continue;
            }

            int mid = (p.from + p.to) / 2;

            q.add(new Node(p.from, mid, p.ind * 2));
            q.add(new Node(mid + 1, p.to, p.ind * 2 + 1));
        }

        for (Node node : roots) {
            node.min = Integer.parseInt(br.readLine());
            node.max = node.min;
        }

        for (Node node : roots) {
            while (node.ind > 1) {
                Node p = tree[node.ind / 2];

                p.max = Math.max(p.max, node.max);
                p.min = Math.min(p.min, node.min);

                node = p;
            }
        }

        for (int i = 0; i < m; i++) {
            int[] query = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int from = query[0] - 1, to = query[1] - 1;

            int[] result = new int[]{Integer.MAX_VALUE, 0};

            findMinMax(result, tree, from, to, 1);

            bw.append(String.valueOf(result[0]));
            bw.append(" ");
            bw.append(String.valueOf(result[1]));
            bw.append("\n");
        }

        bw.flush();
    }

    public static void findMinMax(int[] result, Node[] tree, int from, int to, int ind) {

        Node node = tree[ind];

        if (from <= node.from && node.to <= to) {
            result[0] = Math.min(result[0], node.min);
            result[1] = Math.max(result[1], node.max);
            return;
        }

        if (to < node.from || node.to < from) return;

        findMinMax(result, tree, from, to, ind * 2);
        findMinMax(result, tree, from, to, ind * 2 + 1);
    }

    public static class Node {
        int from;
        int to;
        int ind;

        int min = Integer.MAX_VALUE;
        int max = 0;

        public Node(int from, int to, int ind) {
            this.from = from;
            this.to = to;
            this.ind = ind;
        }
    }
}
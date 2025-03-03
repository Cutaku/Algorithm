package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 덱조작과쿼리_32354 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[n + 1];
        nodes[0] = new Node(0, null);

        Node now = nodes[0];

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            String[] query = br.readLine().split(" ");

            switch (query[0]) {
                case "push" -> now = new Node(now.sum + Integer.parseInt(query[1]), now);
                case "pop" -> now = now.pre;
                case "restore" -> now = nodes[Integer.parseInt(query[1])];
                default -> sb.append(now.sum).append("\n");
            }

            nodes[i] = now;
        }

        System.out.println(sb);
    }

    static class Node {

        long sum;
        Node pre;

        public Node(long sum, Node pre) {
            this.sum = sum;
            this.pre = pre;
        }
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 영과일2_8112 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        a: while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            if (n == 1) {
                sb.append("1\n");
                continue;
            }

            Queue<Node> q = new ArrayDeque<>();
            boolean[] v = new boolean[n];

            q.add(new Node("1", 1));
            v[1] = true;

            while (!q.isEmpty()) {
                Node now = q.poll();

                if (now.left == 0) {
                    sb.append(now.num).append("\n");
                    continue a;
                }

                if (!v[now.left * 10 % n]) {
                    v[now.left * 10 % n] = true;
                    q.add(new Node(now.num + "0", now.left * 10 % n));
                }

                if (!v[(now.left * 10 + 1) % n]) {
                    v[(now.left * 10 + 1) % n] = true;
                    q.add(new Node(now.num + "1", (now.left * 10 + 1) % n));
                }
            }

            sb.append("BRAK\n");
        }

        System.out.println(sb);
    }

    static class Node {

        String num;
        int left;

        public Node(String num, int left) {
            this.num = num;
            this.left = left;
        }
    }
}
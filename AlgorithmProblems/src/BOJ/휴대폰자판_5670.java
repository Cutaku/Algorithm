package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 휴대폰자판_5670 {
    static double res;
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);

            Node root = new Node('.');

            for (int i = 0; i < n; i++) {
                String str = br.readLine();

                Node now = root;

                for (int j = 0; j < str.length(); j++) {
                    now = now.getNext(str.charAt(j));
                }

                now.fin = true;
            }

            res = 0;
            count = 0;

            find(root, 0);

            System.out.printf("%.2f\n", res / count);
        }
    }

    static void find(Node node, int d) {

        if (node.fin) {
            res += d;
            count++;
        }

        if (node.cNext > 1 || node.c == '.' || node.fin) {
            for (Node next : node.next) {
                if (next == null) continue;

                find(next, d + 1);
            }
        } else {
            for (Node next : node.next) {
                if (next == null) continue;

                find(next, d);
            }
        }
    }

    static class Node {
        char c;
        Node[] next = new Node['z' - 'a' + 1];
        boolean fin;
        int cNext;

        public Node(char c) {
            this.c = c;
        }

        Node getNext(char c) {
            if (next[c - 'a'] == null) {
                next[c - 'a'] = new Node(c);
                cNext++;
            }

            return next[c - 'a'];
        }
    }
}
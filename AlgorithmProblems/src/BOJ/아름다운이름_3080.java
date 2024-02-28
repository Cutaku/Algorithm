package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 아름다운이름_3080 {
    static int d = 1000000007;
    static int[] factorial;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        factorial = new int[n + 1];

        factorial[1] = 1;
        for (int i = 2; i <= n; i++) {
            long f = (long) factorial[i - 1] * i;
            factorial[i] = (int) (f % d);
        }

        Node root = new Node(' ');

        for (int i = 0; i < n; i++) {
            String word = br.readLine();

            Node now = root;

            for (int j = 0; j < word.length(); j++) {
                now = now.getNext(word.charAt(j));
            }

            now.fin = true;
        }

        System.out.println(count(root));
    }

    static long count(Node node) {

        if (node.cNext == 0) return 1;

        long res = 1;

        for (Node next : node.next) {
            if (next == null) continue;
            res *= count(next);
            res %= d;
        }

        if (node.fin) {
            res *= factorial[node.cNext + 1];
        } else {
            res *= factorial[node.cNext];
        }
        res %= d;

        return res;
    }

    static class Node {
        char c;
        Node[] next = new Node['Z' - 'A' +  1];
        boolean fin;
        int cNext;

        public Node(char c) {
            this.c = c;
        }

        Node getNext(char c) {
            if (next[c - 'A'] == null) {
                next[c - 'A'] = new Node(c);
                cNext++;
            }

            return next[c - 'A'];
        }
    }
}
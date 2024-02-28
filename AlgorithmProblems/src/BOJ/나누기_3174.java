package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 나누기_3174 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int d = 1337377;

        String str = br.readLine();
        int l = str.length();

        int n = Integer.parseInt(br.readLine());

        Node root = new Node(' ');

        for (int i = 0; i < n; i++) {
            String word = br.readLine();

            Node now = root;

            for (int j = 0; j < word.length(); j++) {
                now = now.getNext(word.charAt(j));
            }

            now.fin = true;
        }

        int[] dp = new int[l + 1];
        dp[0] = 1;

        for (int i = 0; i < l; i++) {
            Node now = root;
            
            int j = 0;
            
            while (i + j < l && now.hasNext(str.charAt(i + j))) {
                now = now.getNext(str.charAt(i + j));

                if (now.fin) dp[i + j + 1] = (dp[i + j + 1] + dp[i]) % d;

                j++;
            }
        }

        System.out.println(dp[l]);
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
        
        boolean hasNext(char c) {
            return next[c - 'a'] != null;
        }
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 비슷한단어_2179 {
    static int max;
    static Node mNode;
    static String[] words;
    static int[] ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Node root = new Node(-1);

        max = 0;
        mNode = root;
        words = new String[n];
        ans = new int[2];

        for (int i = 0; i < n; i++) {
            String word = br.readLine();

            words[i] = word;

            Node last = root;

            for (int j = 0; j < word.length(); j++) {
                last = last.find(i, j);
            }
        }

        if (max == 0) ans = new int[]{0, 1};

        System.out.println(words[ans[0]]);
        System.out.println(words[ans[1]]);
    }

    static class Node {

        Node[] next = new Node[26];

        int idx;

        public Node(int idx) {
            this.idx = idx;
        }

        Node find(int idx, int i) {
            char c = words[idx].charAt(i);

            if (next[c - 'a'] == null) {
                next[c - 'a'] = new Node(idx);
            } else if (i + 1 == max) {
                if (ans[0] > next[c - 'a'].idx) {
                    ans[0] = next[c - 'a'].idx;
                    ans[1] = idx;
                }
            } else if (i + 1 > max) {
                max = i + 1;
                ans[0] = next[c - 'a'].idx;
                ans[1] = idx;
            }

            return next[c - 'a'];
        }
    }
}
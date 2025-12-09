package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 코코스_3178 {
    static int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        Node lRoot = new Node();
        Node rRoot = new Node();
        ans = 0;

        for (int i = 0; i < n; i++) {
            String word = br.readLine();

            Node left = lRoot;
            Node right = rRoot;

            for (int j = 0; j < k; j++) {
                left = left.find(word.charAt(j));
                right = right.find(word.charAt(2 * k - 1 - j));
            }
        }

        System.out.println(ans);
    }

    static class Node {

        Node[] children = new Node[26];

        Node find(char c) {

            if (children[c - 'A'] == null) {
                children[c - 'A'] = new Node();
                ans++;
            }

            return children[c - 'A'];
        }
    }
}
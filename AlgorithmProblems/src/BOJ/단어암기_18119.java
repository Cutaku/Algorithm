package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 단어암기_18119 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[] words = new int[n];

        for (int i = 0; i < n; i++) {
            String word = br.readLine();

            for (int j = 0; j < word.length(); j++) {
                words[i] |= 1 << (word.charAt(j) - 'a');
            }
        }

        int remember = (1 << 27) - 1;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            String q = br.readLine();
            int idx = q.charAt(2) - 'a';

            if (q.charAt(0) == '1') remember -= 1 << idx;
            else remember += 1 << idx;

            int cnt = 0;

            for (int j = 0; j < n; j++) {
                if ((words[j] & remember) == words[j]) cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
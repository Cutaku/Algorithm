package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가르침_1062 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        if (k < 5) {
            System.out.println(0);
            return;
        }

        int[] idx = new int[130];

        idx['a'] = -1;
        idx['c'] = -1;
        idx['i'] = -1;
        idx['n'] = -1;
        idx['t'] = -1;

        for (int i = 'd'; i < 'i'; i++) {
            idx[i] = i - 'b' - 1;
        }

        for (int i = 'j'; i < 'n'; i++) {
            idx[i] = i - 'b' - 2;
        }

        for (int i = 'o'; i < 't'; i++) {
            idx[i] = i - 'b' - 3;
        }

        for (int i = 'u'; i <= 'z'; i++) {
            idx[i] = i - 'b' - 4;
        }

        int[] words = new int[n];

        for (int i = 0; i < n; i++) {
            String word = br.readLine();

            for (int j = 0; j < word.length(); j++) {
                if (idx[word.charAt(j)] >= 0) words[i] |= 1 << idx[word.charAt(j)];
            }
        }

        int ans = 0;

        for (int i = 0; i < 1 << 21; i++) {
            if (Integer.bitCount(i) > k - 5) continue;

            int count = 0;

            for (int j = 0; j < n; j++) {
                if ((words[j] | i) == i) count++;
            }

            ans = Math.max(ans, count);
        }

        System.out.println(ans);
    }
}
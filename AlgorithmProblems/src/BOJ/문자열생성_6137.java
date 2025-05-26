package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열생성_6137 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] S = new String[n];
        for (int i = 0; i < n; i++) S[i] = br.readLine();

        int l = 0, r = n - 1;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int c = S[l].compareTo(S[r]);

            if (c < 0) {
                sb.append(S[l++]);
            } else if (c > 0) {
                sb.append(S[r--]);
            } else {
                int s = l, e = r;

                while (s < e && S[s].equals(S[e])) {
                    s++;
                    e--;
                }

                if (S[s].compareTo(S[e]) < 0) sb.append(S[l++]);
                else sb.append(S[r--]);
            }

            if (i % 80 == 79) sb.append("\n");
        }

        System.out.println(sb);
    }
}
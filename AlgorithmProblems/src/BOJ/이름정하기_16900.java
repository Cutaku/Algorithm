package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이름정하기_16900 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] s = st.nextToken().toCharArray();

        int n = s.length;
        int k = Integer.parseInt(st.nextToken());

        int[] pi = new int[n];

        for (int i = 1; i < n; i++) {
            int l = pi[i - 1];

            while (l > 0 && s[l] != s[i]) {
                l = pi[l - 1];
            }

            pi[i] = l;
            if (s[l] == s[i]) pi[i]++;
        }

        System.out.println(n + (k - 1) * (long) (n - pi[n - 1]));
    }
}
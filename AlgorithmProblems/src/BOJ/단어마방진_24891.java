package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 단어마방진_24891 {
    static int l, n;
    static String[] words, ans;
    static int[] toInt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        words = new String[n];
        for (int i = 0; i < n; i++) words[i] = br.readLine();

        Arrays.sort(words);

        ans = new String[l];

        toInt = new int[(1 << n - 1) + 1];
        for (int i = 0; i < n; i++) {
            toInt[1 << i] = i;
        }

        dfs(0, (1 << n) - 1);

        System.out.println("NONE");
    }

    static void dfs(int d, int left) {

        if (d == l) {
            for (int j = 0; j < l; j++) {
                System.out.println(ans[j]);
            }

            System.exit(0);
        }

        int q = left;

        a: while (q > 0) {
            int b = q & -q;
            q -= b;
            int j = toInt[b];

            for (int k = 0; k < d; k++) {
                if (ans[k].charAt(d) > words[j].charAt(k)) continue a;
                if (ans[k].charAt(d) < words[j].charAt(k)) break a;
            }

            ans[d] = words[j];

            dfs(d + 1, left - b);
        }
    }
}
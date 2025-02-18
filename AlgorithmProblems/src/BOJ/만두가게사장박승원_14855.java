package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 만두가게사장박승원_14855 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());

        List<int[]> list = new ArrayList<>();

        int z = n / x;

        while (z > 0) {
            int q = 1;

            while (q <= z) {
                list.add(new int[]{q * x, q * y});
                z -= q;
                q <<= 1;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());

            z = Math.min(a / b, n / c);

            while (z > 0) {
                int q = 1;

                while (q <= z) {
                    list.add(new int[]{q * c, q * d});
                    z -= q;
                    q <<= 1;
                }
            }
        }

        int[] dp = new int[n + 1];

        for (int[] dumpling : list) {
            for (int i = n; i >= dumpling[0]; i--) {
                dp[i] = Math.max(dp[i], dp[i - dumpling[0]] + dumpling[1]);
            }
        }

        System.out.println(dp[n]);
    }
}
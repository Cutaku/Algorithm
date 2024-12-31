package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 두더지잡기_2259 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken());

        int[][] moles = new int[n + 1][];
        moles[0] = new int[]{0, 0, 0};

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            moles[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(moles, Comparator.comparingInt(a -> a[2]));

        int[] dp = new int[n + 1];

        int max = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (j > 0 && dp[j] == 0) continue;

                if (inRange(moles[i][0] - moles[j][0], moles[i][1] - moles[j][1], moles[i][2] - moles[j][2], s)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        System.out.println(max);
    }

    static boolean inRange(int dx, int dy, long dt, long s) {

        double d = Math.sqrt(dx * dx + dy * dy);

        return d <= dt * s;
    }
}
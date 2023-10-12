package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일이삼더하기사_15989 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[][] ans = new int[10001][4];

        ans[1][1] = 1;
        ans[2][1] = 1;
        ans[2][2] = 1;
        ans[3][1] = 1;
        ans[3][2] = 1;
        ans[3][3] = 1;

        int s = 3;

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            if (n > s) {
                for (int i = s + 1; i <= n; i++) {
                    ans[i][1] = ans[i - 1][1];
                    ans[i][2] = ans[i - 2][1] + ans[i - 2][2];
                    ans[i][3] = ans[i - 3][1] + ans[i - 3][2] + ans[i - 3][3];
                }

                s = n;
            }

            System.out.println(ans[n][1] + ans[n][2] + ans[n][3]);
        }
    }
}
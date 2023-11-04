package BOJ;

import java.io.*;

public class 감소하는수_1038 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] combination = new int[11][11];
        for (int i = 0; i <= 10; i++) {
            combination[i][0] = 1;
        }

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= i; j++) {
                combination[i][j] = combination[i][j - 1] * (i - j + 1) / j;
            }
        }

        int n = Integer.parseInt(br.readLine());

        int[] count = new int[11];

        for (int i = 1; i <= 10; i++) {
            count[i] += count[i - 1];
            count[i] += combination[10][i];
        }

        int l = 1;

        while (l <= 10 && n >= count[l]) l++;

        if (l > 10) {
            System.out.println(-1);
            return;
        }

        n -= count[l - 1];

        int[] ans = new int[l];

        for (int i = 0; i < l; i++) {
            int m = l - i - 1;

            while (n > 0 && n >= combination[m][l - i - 1]) {
                n -= combination[m][l - i - 1];
                m++;
            }

            ans[i] = m;
        }

        for (int a : ans) {
            bw.append(String.valueOf(a));
        }

        bw.flush();
    }
}
package BOJ;

import java.io.*;
import java.util.Arrays;

public class 반복하지않는수_7696 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] c1 = new int[10];
        c1[0] = 9;

        for (int i = 1; i < 10; i++) c1[i] = c1[i - 1] * (10 - i);

        int[][] c2 = new int[10][10];
        Arrays.fill(c2[0], 1);

        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                c2[i][j] = c2[i - 1][j] * (10 - i - j);
            }
        }

        int n;

        while ((n = Integer.parseInt(br.readLine())) > 0) {
            int[] arr = new int[10];
            arr[0] = 1;

            int l = 0;

            while (n > c1[l]) {
                n -= c1[l];
                l++;
            }

            boolean[] used = new boolean[10];

            for (int i = 0; i <= l; i++) {

                int c = 0;

                while (n > c2[l - i][i]) {
                    n -= c2[l - i][i];
                    c++;
                }

                for (int j = 0; j < 10; j++) {
                    if (used[j]) continue;

                    if (c == 0) {
                        arr[i] += j;
                        break;
                    }

                    c--;
                }

                used[arr[i]] = true;
            }

            for (int i = 0; i <= l; i++) {
                bw.append(String.valueOf(arr[i]));
            }

            bw.append("\n");
        }

        bw.flush();
    }
}
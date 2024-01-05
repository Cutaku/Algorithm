package SWExpertAcademy;

import java.io.*;
import java.util.Arrays;

public class 영어공부_10507 {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            bw.append("#").append(String.valueOf(tc)).append(" ");

            int[] np = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = np[0], p = np[1];

            int[] dates = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[] dif = new int[n - 1];
            for (int i = 1; i < n; i++) dif[i - 1] = dates[i] - dates[i - 1] - 1;

            int s = 0;
            int e = 0;

            int sum = 1;
            int max = 1 + p;

            int t = p;

            while (e < n - 1) {
                if (p >= dif[e]) {
                    p -= dif[e];
                    sum += dif[e++] + 1;
                    max = Math.max(max,  sum + p);
                } else {
                    p += dif[s];
                    sum -=dif[s++] + 1;

                    if (e < s) {
                        sum = 1;
                        p = t;
                        e++;
                    }
                }
            }

            bw.append(String.valueOf(max)).append("\n");
        }

        bw.flush();
    }
}
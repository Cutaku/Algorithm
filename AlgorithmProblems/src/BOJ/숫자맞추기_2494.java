package BOJ;

import java.io.*;

public class 숫자맞추기_2494 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String e = br.readLine();

        int[] dif = new int[n];
        for (int i = 0; i < n; i++) {
            dif[i] = s.charAt(n - 1 - i) - e.charAt(n - 1 - i);
            if (dif[i] < 0) dif[i] += 10;
        }

        int[][][] count = new int[n + 1][10][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                int d = (dif[i] + j) % 10;

                int right = count[i][j][0] + d;
                int left = count[i][(j + 10 - d) % 10][0] + 10 - d;

                if (left < right) {
                    count[i + 1][j][0] = left;
                    count[i + 1][j][1] = 10 - d;
                } else {
                    count[i + 1][j][0] = right;
                    count[i + 1][j][1] = d * -1;
                }
            }
        }

        bw.append(String.valueOf(count[n][0][0]));
        bw.append("\n");

        int r = 0;

        for (int i = n; i > 0; i--) {
            bw.append(String.valueOf(n - i + 1));
            bw.append(" ");
            bw.append(String.valueOf(count[i][r][1]));
            bw.append("\n");

            if (count[i][r][1] > 0) {
                r += count[i][r][1];
                if (r >= 10) r -= 10;
            }
        }

        bw.flush();
    }
}
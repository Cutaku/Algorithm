package BOJ;

import java.io.*;
import java.util.Arrays;

public class 사전_1256 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = numbers[0], m = numbers[1], k = numbers[2];

        long[][] count = new long[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            count[i][0] = 1;
        }

        for (int i = 0; i <= m; i++) {
            count[0][i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                count[i][j] = count[i - 1][j] + count[i][j - 1];
                count[i][j] = Math.min(count[i][j], 1000000001);
            }
        }

        if (k > count[n][m]) {
            System.out.println(-1);
            return;
        }

        int a = n - 1;
        int b = m;

        for (int i = 0; i < n + m; i++) {
            if (a >= 0 && b >= 0) {
                if (k > count[a][b]) {
                    bw.append('z');
                    k -= count[a][b];
                    b--;
                } else {
                    bw.append('a');
                    a--;
                }
            } else {
                bw.append('z');
            }
        }

        bw.flush();
    }
}
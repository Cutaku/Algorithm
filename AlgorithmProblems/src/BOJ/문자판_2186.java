package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 문자판_2186 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nmk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nmk[0], m = nmk[1], k = nmk[2];

        char[][] board = new char[n][];
        for (int i = 0; i < n; i++) board[i] = br.readLine().toCharArray();

        char[] target = br.readLine().toCharArray();

        int l = target.length;

        int[][] count = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == target[0]) count[i][j] = 1;
            }
        }

        for (int i = 1; i < l; i++) {
            int[][] temp = new int[n][m];

            for (int j = 0; j < n; j++) {
                for (int o = 0; o < m; o++) {
                    if (board[j][o] != target[i]) continue;

                    for (int p = Math.max(0, j - k); p <= Math.min(n - 1, j + k); p++) {
                        if (p == j) continue;

                        if (board[p][o] == target[i - 1]) temp[j][o] += count[p][o];
                    }

                    for (int p = Math.max(0, o - k); p <= Math.min(m - 1, o + k); p++) {
                        if (p == o) continue;

                        if (board[j][p] == target[i - 1]) temp[j][o] += count[j][p];
                    }
                }
            }

            count = temp;
        }


        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += count[i][j];
            }
        }

        System.out.println(ans);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 뒤집기_15999 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        boolean[][] board = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) == 'W';
            }
        }

        boolean[][] v = new boolean[n][m];
        int cnt = n * m;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i < n - 1 && board[i][j] ^ board[i + 1][j]) {
                    if (!v[i][j]) {
                        v[i][j] = true;
                        cnt--;
                    }

                    if (!v[i + 1][j]) {
                        v[i + 1][j] = true;
                        cnt--;
                    }
                }

                if (j < m - 1 && board[i][j] ^ board[i][j + 1]) {
                    if (!v[i][j]) {
                        v[i][j] = true;
                        cnt--;
                    }

                    if (!v[i][j + 1]) {
                        v[i][j + 1] = true;
                        cnt--;
                    }
                }
            }
        }

        long a = 2;
        long ans = 1;

        while (cnt > 0) {
            if (cnt % 2 == 0) {
                a = a * a % 1000000007;
                cnt /= 2;
            } else {
                ans = ans * a % 1000000007;
                cnt--;
            }
        }

        System.out.println(ans);
    }
}
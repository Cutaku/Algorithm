package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 갤러리_2115 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());

        boolean[][] isWall = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String line = br.readLine();

            for (int j = 0; j < n; j++) {
                isWall[i][j] = line.charAt(j) == 'X';
            }
        }

        int ans = 0;

        for (int i = 1; i < m; i++) {
            int c = 0;

            for (int j = 0; j < n; j++) {
                if (isWall[i][j] ^  isWall[i - 1][j]) {
                    c++;

                    if (c == 2) {
                        if (isWall[i][j] ^ isWall[i][j - 1]) {
                            c = 1;
                        } else {
                            ans++;
                            c = 0;
                        }
                    }
                } else {
                    c = 0;
                }
            }
        }

        for (int j = 1; j < n; j++) {
            int c = 0;

            for (int i = 0; i < m; i++) {
                if (isWall[i][j] ^ isWall[i][j - 1]) {
                    c++;

                    if (c == 2) {
                        if (isWall[i][j] ^ isWall[i - 1][j]) {
                            c = 1;
                        } else {
                            ans++;
                            c = 0;
                        }
                    }
                } else {
                    c = 0;
                }
            }
        }

        System.out.println(ans);
    }
}
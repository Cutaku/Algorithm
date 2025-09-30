package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 경로게임_12887 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[][] isWhite = new boolean[2][n];

        int ans = -n;

        for (int i = 0; i < 2; i++) {
            String line =  br.readLine();

            for (int j = 0; j < n; j++) {
                if (isWhite[i][j] = (line.charAt(j) == '.')) ans++;
            }
        }

        int remove = n;

        for (int i = 0; i < 2; i++) {
            if (!isWhite[i][0]) continue;

            int idx = i;
            int cnt = 0;

            for (int j = 1; j < n; j++) {
                if (!isWhite[idx][j]) {
                    idx = 1 - idx;
                    cnt++;
                }
            }

            remove = Math.min(remove, cnt);
        }

        System.out.println(ans - remove);
    }
}
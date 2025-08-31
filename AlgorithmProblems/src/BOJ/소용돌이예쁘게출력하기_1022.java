package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소용돌이예쁘게출력하기_1022 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        String[][] ans = new String[r2 - r1 + 1][c2 - c1 + 1];
        int maxLen = 0;

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                ans[i - r1][j - c1] = find(i, j);
                maxLen = Math.max(maxLen, ans[i - r1][j - c1].length());
            }
        }

        StringBuilder sb = new StringBuilder();

        String[] blank = new String[15];
        blank[0] = "";
        for (int i = 1; i < 15; i++) blank[i] = blank[i - 1] + " ";

        for (int i = 0; i <= r2 - r1; i++) {
            for (int j = 0; j <= c2 - c1; j++) {
                sb.append(blank[maxLen - ans[i][j].length()]).append(ans[i][j]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static String find(int r, int c) {

        int d = Math.max(Math.abs(r), Math.abs(c));
        int s = (2 * d + 1) * (2 * d + 1);

        int res;

        if (r == d) res = s - d + c;
        else if (c == -d) res = s - 3 * d + r;
        else if (r == -d) res = s - 5 * d - c;
        else res = s - 7 * d - r;

        return String.valueOf(res);
    }
}
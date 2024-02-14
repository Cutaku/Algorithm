package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이만들기_2630 {
    static int n;
    static int[][] paper;
    static int blue, white;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        paper = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                paper[i][j] += paper[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                paper[i][j] += paper[i - 1][j];
            }
        }

        white = 0;
        blue = 0;

        color(n, n, n);

        System.out.println(white);
        System.out.println(blue);
    }

    static void color(int i, int j, int r) {

        int count = paper[i][j] - paper[i][j - r] - paper[i - r][j] + paper[i - r][j - r];

        if (count == 0) {
            white++;
            return;
        } else if (count == r * r) {
            blue++;
            return;
        }

        r /= 2;

        color(i - r, j - r, r);
        color(i - r, j, r);
        color(i, j - r, r);
        color(i, j, r);
    }
}
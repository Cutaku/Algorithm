package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장큰숫자_16458 {
    static int n, m;
    static boolean[][] black;
    static int[] bin = {31599, 25751, 25255, 29391, 6009, 31119, 18927, 29348, 31727, 31689};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        black = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < m; j++) {
                black[i][j] = line.charAt(j) == '*';
            }
        }
        
        int maxNum = 0;
        int maxSize = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (!black[r][c]) continue;

                int s = size(r, c);
                int num;

                if (isFour(r, c, s)) {
                    num = 4;
                    mkWhite(r, c - 2 * s, s, bin[4]);
                } else {
                    num = find(r, c, s);
                    mkWhite(r, c, s, bin[num]);
                }

                if (s > maxSize) {
                    maxSize = s;
                    maxNum = num;
                }
            }
        }

        System.out.println(maxNum);
    }
    
    static boolean isFour(int r, int c, int s) {

        if (c + s >= m) return true;
        
        for (int i = 0; i < 5; i++) {
            if (black[r + i * s][c + s]) return false;
        }
        
        return true;
    }

    static int find(int r, int c, int s) {

        int b = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                b <<= 1;
                if (black[r + i * s][c + j * s]) b |= 1;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (bin[i] == b) return i;
        }

        return 9;
    }

    static int size(int r, int c) {

        int s = 1;

        a: while (true) {
            if (r + s >= n || c + s >= m) break;

            for (int i = 0; i <= s; i++) {
                if (!black[r + s][c + i] || !black[r + i][c + s]) break a;
            }

            s++;
        }

        return s;
    }

    static void mkWhite(int r, int c, int s, int b) {

        for (int i = 4; i >= 0; i--) {
            for (int j = 2; j >= 0; j--) {
                if (b % 2 == 1) mkWhite(r + i * s, c + j * s, s);

                b /= 2;
            }
        }
    }

    static void mkWhite(int r, int c, int s) {

        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                black[r + i][c + j] = false;
            }
        }
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 컨닝_1014 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] bits = new boolean[1024][10];

        for (int i = 0; i < 1024; i++) {
            int n = i;

            for (int j = 0; j < 10; j++) {
                if (n == 0) continue;

                bits[i][j] = n % 2 == 1;
                n /= 2;
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 1024; i++) {
            if (check1(bits[i])) list.add(i);
        }

        int l = list.size();

        boolean[][] fb = new boolean[l][l];

        for (int i = 0; i < l - 1; i++) {
            for (int j = i + 1; j < l; j++) {
                if (check2(bits[list.get(i)], bits[list.get(j)])) {
                    fb[i][j] = true;
                    fb[j][i] = true;
                }
            }
        }

        int[] count = new int[1024] ;

        for (int i : list) {
            for (int j = 0; j < 10; j++) {
                if (bits[i][j]) count[i]++;
            }
        }

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = nm[0], m = nm[1];
            int s = 1 << m;

            char[][] classroom = new char[n][];
            for (int i = 0; i < n; i++) classroom[i] = br.readLine().toCharArray();

            int[] dp = Arrays.copyOf(count, s);

            for (int i = 0; i < s; i++) {
                for (int j = 0; j < m; j++) {
                    if (bits[i][j] && classroom[0][j] == 'x') {
                        dp[i] = 0;
                        break;
                    }
                }
            }

            for (int row = 0; row < n - 1; row++) {
                int[] temp = new int[s];

                for (int i : list) {
                    if (i >= s) break;

                    for (int j : list) {
                        if (j >= s) break;

                        boolean b = false;

                        for (int k = 0; k < m; k++) {
                            if (bits[j][k] && classroom[row + 1][k] == 'x') {
                                b = true;
                                break;
                            }
                        }

                        if (b) continue;

                        if (check2(bits[i], bits[j])) {
                            temp[j] = Math.max(temp[j], dp[i] + count[j]);
                        }
                    }
                }

                dp = temp;
            }

            int max = 0;

            for (int d : dp) max = Math.max(max, d);

            System.out.println(max);
        }
    }

    static boolean check1(boolean[] a) {

        for (int i = 0; i < 9; i++) {
            if (a[i] && a[i + 1]) return false;
        }

        return true;
    }

    static boolean check2(boolean[] a, boolean[] b) {

        for (int i = 0; i < 10; i++) {
            if (!b[i]) continue;

            if (i > 0 && a[i - 1]) return false;
            if (i < 9 && a[i + 1]) return false;
        }

        return true;
    }
}
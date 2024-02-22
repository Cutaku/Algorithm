package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 보호필름_2112 {
    static int d, w, k;
    static int[] film;
    static int min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append('#').append(tc).append(' ');

            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            film = new int[d];

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < w; j++) {
                    film[i] <<= 1;
                    film[i] |= Integer.parseInt(st.nextToken());
                }
            }

            min = k;

            dfs(0, 0);

            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int depth, int c) {

        if (depth == d) {
            if (pass()) {
                min = Math.min(min, c);
            }

            return;
        }

        dfs(depth + 1, c);

        if (c + 1 >= min) return;

        int temp = film[depth];

        changeChar(depth, 0);
        dfs(depth + 1, c + 1);

        changeChar(depth, 1);
        dfs(depth + 1, c + 1);

        film[depth] = temp;
    }

    static boolean pass() {

        for (int i = 0; i < w; i++) {
            int max = 1;
            int count = 1;

            for (int j = 1; j < d; j++) {
                if ((film[j] & (1 << i)) == (film[j - 1] & (1 << i))) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 1;
                }
            }

            if (max < k) return false;
        }

        return true;
    }

    static void changeChar(int l, int c) {

        if (c == 0) film[l] = 0;
        else film[l] = (1 << w) - 1;
    }
}
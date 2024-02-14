package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무높이_14510 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append('#').append(tc).append(' ');

            int n = Integer.parseInt(br.readLine());

            int max = 0;

            int[] trees = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                trees[i] = Integer.parseInt(st.nextToken());

                max = Math.max(max, trees[i]);
            }

            int a = 0;
            int b = 0;

            for (int tree : trees) {
                int d = max - tree;

                a += d % 2;
                b += d / 2;
            }

            int d = Math.max((b - a + 1) / 3, 0);
            a += 2 * d;
            b -= d;

            if (a > b) sb.append(2 * a - 1).append("\n");
            else sb.append(2 * b).append("\n");
        }

        System.out.println(sb);
    }
}
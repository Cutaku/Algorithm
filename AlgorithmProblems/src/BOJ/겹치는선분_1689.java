package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 겹치는선분_1689 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] points = new int[2 * n][];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            points[2 * i] = new int[]{Integer.parseInt(st.nextToken()), 1};
            points[2 * i + 1] = new int[]{Integer.parseInt(st.nextToken()), 0};
        }

        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int cnt = 0;
        int max = 0;

        for (int i = 0; i < 2 * n; i++) {
            if (points[i][1] == 1) max = Math.max(max, ++cnt);
            else cnt--;
        }

        System.out.println(max);
    }
}
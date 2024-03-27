package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 장훈이의높은선반_1486 {
    static int n, b;
    static int[] heights = new int[20];
    static int min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append('#').append(tc).append(' ');

            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            heights = new int[n];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }

            min = Integer.MAX_VALUE;

            dfs(0, 0);

            sb.append(min - b).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int d, int sum) {

        if (d == n) {
            if (sum >= b && min > sum) min = sum;
            return;
        }

        dfs(d + 1, sum + heights[d]);
        dfs(d + 1, sum);
    }
}
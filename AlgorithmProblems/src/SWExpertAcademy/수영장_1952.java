package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수영장_1952 {
    static int[] period = new int[4];
    static int[] price = new int[4];
    static int[] months = new int[12];
    static int min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        period = new int[]{0, 1, 3, 12};

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append('#').append(tc).append(' ');

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 4; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            min = price[3];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 12; i++) {
                months[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);

            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int m, int sum) {

        if (m > 11) {
            min = Math.min(min, sum);
            return;
        }

        while (m < 11 && months[m] == 0) m++;

        dfs(m + 1, sum + price[0] * months[m]);

        for (int i = 1; i < 3; i++) {
            dfs(m + period[i], sum + price[i]);
        }
    }
}
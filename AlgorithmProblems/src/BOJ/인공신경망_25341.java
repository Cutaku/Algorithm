package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 인공신경망_25341 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] hidden = new int[m][];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());

            hidden[i] = new int[2 * c + 2];
            hidden[i][0] = c;

            for (int j = 1; j <= c; j++) hidden[i][j] = Integer.parseInt(st.nextToken()) - 1;
            for (int j = c + 1; j < 2 * c + 2; j++) hidden[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] output = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) output[i] = Integer.parseInt(st.nextToken());

        int[] weight = new int[n];
        int bias = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            int c = hidden[i][0];

            for (int j = 1; j <= c; j++) {
                weight[hidden[i][j]] += hidden[i][j + c] * output[i];
            }

            bias += hidden[i][2 * c + 1] * output[i];
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            long res = bias;
            for (int j = 0; j < n; j++) res += Long.parseLong(st.nextToken()) * weight[j];

            sb.append(res).append("\n");
        }

        System.out.println(sb);
    }
}
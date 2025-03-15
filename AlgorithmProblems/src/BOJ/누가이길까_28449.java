package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 누가이길까_28449 {
    static int[] sum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        sum = new int[100001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) sum[Integer.parseInt(st.nextToken())]++;
        for (int i = 1; i < 100001; i++) sum[i] += sum[i - 1];

        long lose = 0, draw = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int ability = Integer.parseInt(st.nextToken());

            lose += sum[ability - 1];
            draw += sum[ability] - sum[ability - 1];
        }

        System.out.println((long) n * m - lose - draw + " " + lose + " " + draw);
    }
}
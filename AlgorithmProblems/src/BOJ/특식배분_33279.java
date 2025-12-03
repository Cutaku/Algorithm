package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 특식배분_33279 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        double[] sum = new double[n + 2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            int k = Integer.parseInt(st.nextToken());

            sum[i + 1] = 1 + (sum[i] - sum[i - k]) / k;
            sum[i + 1] += sum[i];
        }

        System.out.println(sum[n + 1] - sum[n]);
    }
}
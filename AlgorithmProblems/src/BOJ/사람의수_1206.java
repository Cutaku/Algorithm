package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 사람의수_1206 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] avg = new int[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("\\.");

            avg[i] = Integer.parseInt(input[0]) * 1000 + Integer.parseInt(input[1]);
        }

        a: for (int m = 1; m < 1001; m++) {
            for (int i = 0; i < n; i++) {
                int s = avg[i] * m / 1000 * 1000;

                if (s / m != avg[i] && (s + 1000) / m != avg[i]) continue a;
            }

            System.out.println(m);
            return;
        }
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 목장건설하기_14925 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] zero = new long[20];
        long[] one = new long[20];

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int name = Integer.parseInt(br.readLine());

            for (int j = 0; j < 20; j++) {
                if ((name & (1 << j)) > 0) one[j]++;
                else zero[j]++;
            }
        }

        long ans = 0;

        for (int i = 0; i < 20; i++) {
            ans += (1 << i) * one[i] * zero[i];
        }

        System.out.println(ans);
    }
}
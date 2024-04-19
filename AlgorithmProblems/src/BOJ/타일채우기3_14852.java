package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타일채우기3_14852 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int d = 1000000007;

        int[] count = new int[n + 1];
        int[] sum = new int[n + 1];

        count[0] = 1;
        count[1] = 2;

        sum[0] = 1;
        sum[1] = 3;

        for (int i = 2; i <= n; i++) {
            count[i] = sum[i - 1] * 2 % d;
            count[i] = (count[i] + count[i - 2]) % d;
            sum[i] = (sum[i - 1] + count[i]) % d;
        }

        System.out.println(count[n]);
    }
}
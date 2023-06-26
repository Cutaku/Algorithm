package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 시그마_13172 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long m = Long.parseLong(br.readLine());

        int d = 1000000007;

        long ans = 0;

        for (int i = 0; i < m; i++) {
            int[] dice = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


            ans += findInverse(dice[0]) * dice[1];
            ans %= d;
        }

        System.out.println(ans);
    }

    public static long findInverse(long n) {

        int d = 1000000007;
        int pow = 1000000005;

        long result = 1;

        while (pow > 0) {
            if (pow % 2 == 1) {
                pow--;
                result *= n;
                result %= d;
            } else {
                pow /= 2;
                n *= n;
                n %= d;
            }
        }

        return result;
    }
}
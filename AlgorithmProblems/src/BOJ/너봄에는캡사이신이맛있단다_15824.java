package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 너봄에는캡사이신이맛있단다_15824 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int d = 1000000007;

        int n = Integer.parseInt(br.readLine());

        long[] scoville = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(scoville);

        for (int i = 0; i < n; i++) scoville[i] %= d;

        long[] pow = new long[n];

        pow[0] = 1;
        for (int i = 1; i < n; i++) pow[i] = (pow[i - 1] * 2) % d;

        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans += scoville[i] * (pow[i] - pow[n - 1 - i]);
            ans %= d;
        }

        if (ans >= 0) System.out.println(ans);
        else System.out.println(ans + d);
    }
}
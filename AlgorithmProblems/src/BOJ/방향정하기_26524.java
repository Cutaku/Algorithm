package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 방향정하기_26524 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long ans = 1;

        for (int i = 1; i <= n; i++) {
            ans = ans * i % 1000000007;
        }

        System.out.println(ans);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 동전2_2294 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0], k = nk[1];

        int m = 10001;

        Set<Integer> coins = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());

            if (coin > k) continue;

            coins.add(coin);
        }

        int[] count = new int[k + 1];
        Arrays.fill(count, m);
        count[0] = 0;

        for (int i = 0; i < k; i++) {
            for (int coin : coins) {
                if (i + coin <= k) {
                    count[i + coin] = Math.min(count[i] + 1, count[i + coin]);
                }
            }
        }

        if (count[k] == m) System.out.println(-1);
        else System.out.println(count[k]);
    }
}
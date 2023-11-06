package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 동전_9084 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            int[] coins = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int m = Integer.parseInt(br.readLine());

            int[] count = new int[m + 1];
            count[0] = 1;

            for (int coin : coins) {
                for (int i = 1; i <= m ; i++) {
                    if (i < coin) continue;

                    count[i] += count[i - coin];
                }
            }

            System.out.println(count[m]);
        }
    }
}
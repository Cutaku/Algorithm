package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 평범한배낭2_12920 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        List<int[]> objects = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

            while (k > 0) {
                int b = 1;

                while (b <= k) {
                    objects.add(new int[]{v * b, c * b});
                    k -= b;
                    b <<= 1;
                }
            }
        }

        int[] backpack = new int[m + 1];

        for (int[] object : objects) {
            for (int i = m; i >= object[0]; i--) {
                backpack[i] = Math.max(backpack[i], backpack[i - object[0]] + object[1]);
            }
        }

        System.out.println(backpack[m]);
    }
}
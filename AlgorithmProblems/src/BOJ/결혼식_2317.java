package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 결혼식_2317 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        int[] lions = new int[k];

        for (int i = 0; i < k; i++) {
            lions[i] = Integer.parseInt(br.readLine());
        }

        int lMin = lions[0], lMax = lions[0];
        int ans = 0;

        for (int i = 1; i < k; i++) {
            ans += Math.abs(lions[i] - lions[i - 1]);

            lMin = Math.min(lMin, lions[i]);
            lMax = Math.max(lMax, lions[i]);
        }

        int min = lMin;
        int max = lMax;

        for (int i = 0; i < n - k; i++) {
            int h = Integer.parseInt(br.readLine());

            min = Math.min(min, h);
            max = Math.max(max, h);
        }

        if (min < lMin) {
            ans += Math.min(2 * (lMin - min), Math.min(lions[0], lions[k - 1]) - min);
        }

        if (max > lMax) {
            ans += Math.min(2 * (max - lMax), max - Math.max(lions[0], lions[k - 1]));
        }

        System.out.println(ans);
    }
}
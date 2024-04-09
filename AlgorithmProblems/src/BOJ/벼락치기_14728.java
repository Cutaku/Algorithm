package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 벼락치기_14728 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken());

        int[] max = new int[t + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken());

            int[] temp = new int[t + 1];

            if (k > t) continue;

            for (int j = 0; j < k; j++) {
                temp[j] = max[j];
            }

            for (int j = k; j <= t; j++) {
                temp[j] = Math.max(max[j], max[j - k] + s);
            }

            max = temp;
        }

        System.out.println(max[t]);
    }
}
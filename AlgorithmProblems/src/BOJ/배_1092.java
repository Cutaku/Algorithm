package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 배_1092 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] crane = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) crane[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int[] box = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) box[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(crane);
        Arrays.sort(box);

        if (box[m - 1] > crane[n - 1]) {
            System.out.println(-1);
            return;
        }

        int min = (m + n - 1) / n;
        int d = n;
        int idx = 0;

        for (int i = 0; i < n - 1; i++) {
            while (idx < m && crane[i] >= box[idx]) {
                idx++;
            }

            d--;

            min = Math.max(min, (m - idx + d - 1) / d);
        }

        System.out.println(min);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 짱해커이동식_25603 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        int[] cost = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) cost[i] = Integer.parseInt(st.nextToken());

        int s = 0, e = 1000000000;

        while (e - s > 1) {
            int m = (s + e) >> 1;

            if (check(cost, m, k)) e = m;
            else s = m;
        }

        System.out.println(e);
    }

    static boolean check(int[] cost, int max, int k) {

        int cnt = 0;

        for (int i = 0; i < k; i++) {
            if (cost[i] <= max) cnt++;
        }

        for (int i = k; i < cost.length; i++) {
            if (cost[i] <= max) cnt++;
            if (cost[i - k] <= max) cnt--;

            if (cnt == 0) return false;
        }

        return true;
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 걷는건귀찮아_20928 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[] p = new int[n];
        int[] q = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) p[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) q[i] = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int max = p[0] + q[0];
        int idx = 1;
        int tmp = 0;

        while (true) {
            if (max >= m) {
                System.out.println(cnt);
                return;
            }

            if (idx == n || p[idx] > max) break;

            while (idx < n && p[idx] <= max) {
                tmp = Math.max(tmp, p[idx] + q[idx++]);
            }

            max = tmp;
            cnt++;
        }

        System.out.println(-1);
    }
}
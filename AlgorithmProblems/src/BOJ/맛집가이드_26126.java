package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 맛집가이드_26126 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] b = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) b[i] = Integer.parseInt(st.nextToken()) - 1;

        boolean[] v = new boolean[n];

        int ans = 0;
        int last = -1;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (v[a[i]]) {
                cnt--;
            } else {
                v[a[i]] = true;
                cnt++;
            }

            if (v[b[i]]) {
                cnt--;
            } else {
                v[b[i]] = true;
                cnt++;
            }

            if (cnt == 0 && i - last >= k) {
                ans++;
                last = i;
            }
        }

        System.out.println(ans);
    }
}
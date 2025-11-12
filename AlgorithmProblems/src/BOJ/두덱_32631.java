package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두덱_32631 {
    static int n, k;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        long[] A = new long[n + 1];
        long[] B = new long[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) A[i] = A[i - 1] + Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) B[i] = B[i - 1] + Long.parseLong(st.nextToken());

        long ans = Long.MAX_VALUE;

        for (int i = 0; i <= k; i++) {
            ans = Math.min(ans, Math.max(min(A, n - i), min(B, n - k + i)));
        }

        System.out.println(ans);
    }

    static long min(long[] arr, int l) {

        long min = arr[l];

        for (int i = l + 1; i <= n; i++) {
            min = Math.min(min, arr[i] - arr[i - l]);
        }

        return min;
    }
}
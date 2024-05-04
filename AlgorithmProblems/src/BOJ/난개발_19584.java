package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 난개발_19584 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[] yValues = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            st.nextToken();
            yValues[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> compress = new HashMap<>();

        int[] arr = Arrays.stream(yValues).distinct().sorted().toArray();
        for (int i = 0; i < arr.length; i++) compress.put(arr[i], i);

        long[] pSum = new long[arr.length + 2];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = compress.get(yValues[Integer.parseInt(st.nextToken()) - 1]);
            int v = compress.get(yValues[Integer.parseInt(st.nextToken()) - 1]);
            int c = Integer.parseInt(st.nextToken());

            pSum[Math.min(u, v)] += c;
            pSum[Math.max(u, v) + 1] -= c;
        }

        long ans = 0;

        for (int i = 0; i <= arr.length; i++) {
            ans = Math.max(ans, pSum[i]);
            pSum[i + 1] += pSum[i];
        }

        System.out.println(ans);
    }
}
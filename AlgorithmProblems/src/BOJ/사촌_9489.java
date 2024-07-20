package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사촌_9489 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n , k;

        int[] arr;
        int[] p = new int[1000001];
        int[] c = new int[1000001];

        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            if (n == 0) break;

            arr = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                p[arr[i]] = 0;
                c[arr[i]] = 0;
            }

            int pIdx = -1;

            for (int i = 1; i < n; i++) {
                if (arr[i] - arr[i - 1] > 1) pIdx++;

                p[arr[i]] = arr[pIdx];
                c[arr[pIdx]]++;
            }

            int parent = p[k];
            int gParent = p[p[k]];

            int res = 0;

            for (int i = 0; i < n; i++) {
                if (p[arr[i]] == gParent && arr[i] != parent) res += c[arr[i]];
            }

            sb.append(res).append("\n");
        }

        System.out.println(sb);
    }
}
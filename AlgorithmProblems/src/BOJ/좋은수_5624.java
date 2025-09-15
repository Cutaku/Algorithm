package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 좋은수_5624 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());

        boolean[] v = new boolean[400002];
        int ans = 0;

        a: for (int i = 1; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            for (int j = 0; j < i; j++) {
                v[arr[j] + arr[i - 1] + 200001] = true;
            }

            for (int j = 0; j < i; j++) {
                if (v[arr[i] - arr[j] + 200001]) {
                    ans++;
                    continue a;
                }
            }
        }

        System.out.println(ans);
    }
}
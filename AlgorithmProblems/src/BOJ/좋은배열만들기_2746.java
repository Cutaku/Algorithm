package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋은배열만들기_2746 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];

        long sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            sum += arr[i];
        }

        Arrays.sort(arr);

        long ans = 0;

        if (sum - arr[n - 1] - arr[n - 2] == 2 * arr[n - 3]) ans++;

        long d = sum - arr[n - 1] - 2 * arr[n - 2];

        for (int i = 0; i < n - 2; i++) {
            if (arr[i] == d) ans++;
        }

        d = sum - 2 * arr[n - 1];

        int s = 0;
        int e = n - 2;

        while (s < e) {
            sum = arr[s] + arr[e];

            if (sum > d) {
                e--;
            } else if (sum < d) {
                s++;
            } else {
                if (arr[s] == arr[e]) {
                    ans += (long) (e - s) * (e - s + 1) / 2;
                    break;
                } else {
                    int a = 1;
                    while (arr[s] == arr[++s]) a++;

                    int b = 1;
                    while (arr[e] == arr[--e]) b++;

                    ans += (long) a * b;
                }
            }
        }

        System.out.println(ans);
    }
}
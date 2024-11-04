package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 라면사기_Large_18186 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken()), c = Long.parseLong(st.nextToken());

        int[] arr = new int[n];

        long count = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            count += arr[i];
        }

        if (b <= c) {
            System.out.println(count * b);
            return;
        }

        long sum = 0;

        for (int i = 0; i < n - 2; i++) {
            int a = Math.min(arr[i], arr[i + 1]);

            if (arr[i + 1] > arr[i + 2]) {
                if (arr[i] > arr[i + 1] - arr[i + 2]) {
                    int d = Math.min(arr[i] - arr[i + 1] + arr[i + 2], arr[i + 2]);

                    sum += d * c;
                    arr[i + 2] -= d;
                }
            } else {
                sum += a * c;
                arr[i + 2] -= a;
            }

            sum += arr[i] * b + a * c;
            arr[i + 1] -= a;
        }

        sum += Math.min(arr[n - 2], arr[n - 1]) * (b + c);
        sum += Math.abs(arr[n - 2] - arr[n - 1]) * b;

        System.out.println(sum);
    }
}
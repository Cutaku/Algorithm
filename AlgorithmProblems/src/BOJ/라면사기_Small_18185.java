package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 라면사기_Small_18185 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int sum = 0;

        for (int i = 0; i < n - 2; i++) {
            int a = Math.min(arr[i], arr[i + 1]);

            if (arr[i + 1] > arr[i + 2]) {
                if (arr[i] > arr[i + 1] - arr[i + 2]) {
                    int b = Math.min(arr[i] - arr[i + 1] + arr[i + 2], arr[i + 2]);

                    sum += b * 2;
                    arr[i + 2] -= b;
                }
            } else {
                sum += a * 2;
                arr[i + 2] -= a;
            }

            sum += arr[i] * 3 + a * 2;
            arr[i + 1] -= a;
        }

        sum += Math.min(arr[n - 2], arr[n - 1]) * 5;
        sum += Math.abs(arr[n - 2] - arr[n - 1]) * 3;

        System.out.println(sum);
    }
}
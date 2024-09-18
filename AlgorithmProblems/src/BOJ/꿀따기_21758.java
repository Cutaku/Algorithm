package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 꿀따기_21758 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());

        int max = 0;

        for (int i = 1; i < n - 1; i++) {
            max = Math.max(max, arr[i - 1] - arr[0] + (arr[n - 1] - arr[i]) * 2);
            max = Math.max(max, arr[i] - arr[0] + arr[n - 2] - arr[i - 1]);
            max = Math.max(max, 2 * arr[i - 1] + arr[n - 2] - arr[i]);
        }

        System.out.println(max);
    }
}
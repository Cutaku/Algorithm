package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일로만들기_1463 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        Arrays.fill(arr, 1000000);
        arr[1] = 0;

        for (int i = 1; i < n + 1; i++) {
            if (i + 1 <= n) {
                arr[i + 1] = Math.min(arr[i + 1], arr[i] + 1);
            }
            if (i * 2 <= n) {
                arr[i * 2] = Math.min(arr[i * 2], arr[i] + 1);
            }
            if (i * 3 <= n) {
                arr[i * 3] = Math.min(arr[i * 3], arr[i] + 1);
            }
        }

        System.out.println(arr[n]);
    }
}
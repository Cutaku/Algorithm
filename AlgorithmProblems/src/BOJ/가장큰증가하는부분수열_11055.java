package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 가장큰증가하는부분수열_11055 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] a = br.readLine().split(" ");
        int[] A = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(a[i - 1]);
        }

        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int[] temp = new int[i];
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) temp[j] = arr[j];
            }

            arr[i] = max(temp) + A[i];
        }

        System.out.println(max(arr));
    }

    static int max(int[] arr) {
        int result = arr[0];

        for (int i : arr) {
            result = Math.max(result, i);
        }

        return result;
    }
}
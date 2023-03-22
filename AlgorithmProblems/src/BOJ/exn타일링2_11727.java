package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exn타일링2_11727 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        arr[0] = 1;
        if (n > 1) arr[1] = 3;

        for (int i = 2; i < n; i++) {
            arr[i] = (arr[i - 1] + 2 * arr[i - 2]) % 10007;
        }

        System.out.println(arr[n - 1]);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일이삼더하기_9095 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] arr = new int[10];
        Arrays.fill(arr, -1);
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;
        for (int i = 3; i < 10; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(arr[n - 1]);
        }
    }
}
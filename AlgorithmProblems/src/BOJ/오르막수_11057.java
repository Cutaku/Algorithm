package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 오르막수_11057 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[10];
        Arrays.fill(arr, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < 10; j++) {
                arr[j] = (arr[j]  + arr[j - 1]) % 10007;
            }
        }

        System.out.println(arr[9]);
    }
}
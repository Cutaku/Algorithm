package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주시식_2156 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] quantities = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            quantities[i] = Integer.parseInt(br.readLine());
        }
        arr[1] = quantities[1];
        if (n > 1) arr[2] = quantities[1] + quantities[2];

        for (int i = 3; i < n + 1; i++) {
            arr[i] = Math.max(quantities[i] + arr[i - 2], quantities[i] + quantities[i - 1] + arr[i - 3]);
            arr[i] = Math.max(arr[i], arr[i - 1]);
        }

        System.out.println(arr[n]);
    }
}
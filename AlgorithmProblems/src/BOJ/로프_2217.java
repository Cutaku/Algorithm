package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 로프_2217 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] weights = new int[n];

        for (int i = 0; i < n; i++) weights[i] = Integer.parseInt(br.readLine());
        Arrays.sort(weights);

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, weights[i] * (n - i));
        }

        System.out.println(max);
    }
}
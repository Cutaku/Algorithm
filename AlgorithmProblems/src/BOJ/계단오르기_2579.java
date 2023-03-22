package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기_2579 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] scores = new int[n + 3];
        int[] max = new int[n + 3];

        for (int i = 3; i < n + 3; i++) {
            scores[i] = Integer.parseInt(br.readLine());
            max[i] = scores[i] + Math.max(max[i - 2], scores[i - 1] + max[i - 3]);
        }

        System.out.println(max[n + 2]);
    }
}
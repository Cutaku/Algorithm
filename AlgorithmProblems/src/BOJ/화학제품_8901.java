package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 화학제품_8901 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int[] abc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = abc[0], b = abc[1], c = abc[2];

            int[] costs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int ab = costs[0], bc = costs[1], ca = costs[2];

            int max = 0;

            for (int i = 0; i <= Math.min(a, b); i++) {
                for (int j = Math.min(b - i, Math.max(0, c - a + i)); j <= Math.min(b - i, c);j++) {
                    max = Math.max(max, ab * i + bc * j + ca * Math.min(a - i, c - j));
                }
            }

            System.out.println(max);
        }
    }
}
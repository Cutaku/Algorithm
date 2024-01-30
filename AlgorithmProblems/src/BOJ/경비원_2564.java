package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 경비원_2564 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] wh = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int w = wh[0], h = wh[1];

        int r = 2 * (w + h);

        int s = Integer.parseInt(br.readLine());

        int[] distance = new int[s + 1];

        for (int i = 0; i <= s; i++) {
            int[] p = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            distance[i] = switch (p[0]) {
                case 1 -> h + p[1];
                case 2 -> r - p[1];
                case 3 -> h - p[1];
                default -> h + w + p[1];
            };
        }

        int sum = 0;

        for (int i = 0; i < s; i++) {
            int d = Math.abs(distance[s] - distance[i]);

            sum += Math.min(d, r - d);
        }

        System.out.println(sum);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 디버깅_24453 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        int[] errors = new int[n + 1];

        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .forEach(i -> errors[i]++);

        int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = xy[0], y = xy[1];

        for (int i = 1; i <= n; i++) {
            errors[i] += errors[i - 1];
        }

        int min = x;

        for (int i = x; i <= n; i++) {
            min = Math.min(min, errors[i] - errors[i - x]);

            if (min <= y) break;
        }

        System.out.println(m - Math.max(y, min));
    }
}
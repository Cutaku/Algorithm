package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 통나무건너뛰기_11497 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] heights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

            int max = Math.min(heights[1] - heights[0], heights[n - 1] - heights[n - 2]);

            for (int i = 2; i < n; i++) {
                max = Math.max(max, heights[i] - heights[i - 2]);
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }
}
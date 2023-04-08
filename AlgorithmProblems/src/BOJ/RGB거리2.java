package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RGB거리2 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] first = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] min = new int[9];
        Arrays.fill(min, 1000000000);

        min[0] = first[0];
        min[4] = first[1];
        min[8] = first[2];

        for (int i = 0; i < n - 1; i++) {
            int[] prices = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[] temp = new int[9];

            temp[0] = prices[0] + Math.min(min[1], min[2]);
            temp[1] = prices[1] + Math.min(min[0], min[2]);
            temp[2] = prices[2] + Math.min(min[0], min[1]);
            temp[3] = prices[0] + Math.min(min[4], min[5]);
            temp[4] = prices[1] + Math.min(min[3], min[5]);
            temp[5] = prices[2] + Math.min(min[3], min[4]);
            temp[6] = prices[0] + Math.min(min[7], min[8]);
            temp[7] = prices[1] + Math.min(min[6], min[8]);
            temp[8] = prices[2] + Math.min(min[6], min[7]);

            min = temp;
        }

        int m = Math.min(min[1], min[2]);
        m = Math.min(m, min[3]);
        m = Math.min(m, min[5]);
        m = Math.min(m, min[6]);
        m = Math.min(m, min[7]);

        System.out.println(m);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 부분합_1806 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] ns = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = ns[0], s = ns[1];

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int min = n + 1;

        int i = 0, j = 0;
        int sum = 0;

        while (j <= n) {
            if (sum >= s) {
                min = Math.min(min, j - i);
                sum -= nums[i++];
            } else  {
                if (j == n) break;
                sum += nums[j++];
            }
        }

        if (min == n + 1) System.out.println(0);
        else System.out.println(min);
    }
}
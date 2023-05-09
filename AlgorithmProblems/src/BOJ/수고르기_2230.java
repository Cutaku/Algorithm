package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수고르기_2230 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(br.readLine());
        Arrays.sort(nums);

        int i = 0;
        int j = 0;

        int min = 2000000000;

        while (j < n) {
            if (i == j) {
                j++;
                continue;
            }

            if (nums[j] - nums[i] < m) {
                j++;
            } else  {
                min = Math.min(min, nums[j] - nums[i]);
                i++;
            }
        }

        System.out.println(min);
    }
}
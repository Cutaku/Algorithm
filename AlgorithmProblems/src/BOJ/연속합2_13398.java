package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 연속합2_13398 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int l = nums.length;

        int[] left = new int[l];
        int[] right = new int[l];

        int leftSum = 0;
        int rightSum = 0;
        int max = nums[0];

        for (int i = 0; i < l; i++) {
            leftSum += nums[i];
            rightSum += nums[l - 1 - i];

            left[i] = leftSum;
            right[l - 1 - i] = rightSum;

            max = Math.max(max, leftSum);

            if (leftSum < 0) leftSum = 0;
            if (rightSum < 0) rightSum = 0;
        }


        for (int i = 1; i < l - 1; i++) {
            max = Math.max(max, left[i - 1] + right[i + 1]);
        }

        System.out.println(max);
    }
}
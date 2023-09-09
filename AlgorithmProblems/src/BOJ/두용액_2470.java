package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 두용액_2470 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] solutions = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(solutions);

        int i = 0;
        int j = n - 1;

        int[] ans = new int[]{0, 0};

        int min = Integer.MAX_VALUE;

        while (i < j) {
            int sum = solutions[i] + solutions[j];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                ans[0] = solutions[i];
                ans[1] = solutions[j];
            }

            if (sum < 0) i++;
            else if (sum > 0) j--;
            else break;
        }

        System.out.println(ans[0] + " " + ans[1]);
    }
}
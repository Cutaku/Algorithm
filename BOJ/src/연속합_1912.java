import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 연속합_1912 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        int max = nums[0];

        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            if (sum < 0) sum = 0;
        }

        System.out.println(max);
    }
}
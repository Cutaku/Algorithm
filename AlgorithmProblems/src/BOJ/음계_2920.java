package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 음계_2920 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean isAscending = true;
        boolean isDescending = true;

        for (int i = 0; i < 8; i++) {
            if (nums[i] != i + 1) isAscending = false;
            if (nums[i] != 8 - i) isDescending = false;
        }

        if (isAscending) System.out.println("ascending");
        else if (isDescending) System.out.println("descending");
        else System.out.println("mixed");
    }
}
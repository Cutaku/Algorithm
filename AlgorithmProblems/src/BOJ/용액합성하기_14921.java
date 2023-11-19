package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 용액합성하기_14921 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] solutions = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int s = 0;
        int e = n - 1;

        int min = Integer.MAX_VALUE;

        while (s < e) {
            int sum = solutions[s] + solutions[e];

            if (Math.abs(sum) < Math.abs(min)) {
                min = sum;
            }

            if (sum > 0) {
                e--;
            } else if (sum < 0) {
                s ++;
            } else {
                break;
            }
        }

        System.out.println(min);
    }
}
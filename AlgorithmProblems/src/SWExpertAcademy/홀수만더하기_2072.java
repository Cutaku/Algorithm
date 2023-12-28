package SWExpertAcademy;

import java.io.*;
import java.util.Arrays;

public class 홀수만더하기_2072 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int sum = 0;

            for (int num : nums) {
                if (num % 2 == 1) {
                    sum += num;
                }
            }

            bw.append("#").append(String.valueOf(t)).append(" ").append(String.valueOf(sum)).append("\n");
        }

        bw.flush();
    }
}
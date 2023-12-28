package SWExpertAcademy;

import java.io.*;
import java.util.Arrays;

public class 최대수구하기_2068 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int max = 0;

            for (int num : nums) {
                max = Math.max(max, num);
            }

            bw.append("#").append(String.valueOf(t)).append(" ").append(String.valueOf(max)).append("\n");
        }

        bw.flush();
    }
}
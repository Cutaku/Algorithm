package SWExpertAcademy;

import java.io.*;
import java.util.Arrays;

public class 백만장자프로젝트_1859 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            bw.append("#").append(String.valueOf(tc)).append(" ");

            int n = Integer.parseInt(br.readLine());

            int[] prices = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int max = 0;

            long sum = 0;

            for (int i = n - 1; i >= 0; i--) {
                max = Math.max(max, prices[i]);

                sum += max - prices[i];
            }

            bw.append(String.valueOf(sum)).append("\n");
        }

        bw.flush();
    }
}
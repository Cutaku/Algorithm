package SWExpertAcademy;

import java.io.*;
import java.util.Arrays;

public class 최빈수구하기_1204 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int tc = Integer.parseInt(br.readLine());

            int[] scores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[] count = new int[101];

            for (int score : scores) {
                count[score]++;
            }

            int max = 0;
            int mode = 0;

            for (int i = 100; i >= 0; i--) {
                if (max < count[i]) {
                    max = count[i];
                    mode = i;
                }
            }

            bw.append("#").append(String.valueOf(tc)).append(" ").append(String.valueOf(mode)).append("\n");
        }

        bw.flush();
    }
}
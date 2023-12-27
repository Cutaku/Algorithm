package SWExpertAcademy;

import java.io.*;
import java.util.Arrays;

public class 두개의숫자열_1959 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = nm[0], m = nm[1];

            int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (n > m) {
                int[] temp = A;
                A = B;
                B = temp;

                int tmp = n;
                n = m;
                m = tmp;
            }

            int max = 0;

            for (int i = 0; i <= m - n; i++) {
                int sum = 0;

                for (int j = 0; j < n; j++) {
                    sum += A[j] * B[i + j];
                }

                max = Math.max(max, sum);
            }


            bw.append("#").append(String.valueOf(t)).append(" ").append(String.valueOf(max)).append("\n");
        }

        bw.flush();
    }
}
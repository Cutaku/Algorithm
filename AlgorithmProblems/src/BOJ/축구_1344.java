package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 축구_1344 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double a = Double.parseDouble(br.readLine()) / 100;
        double b = Double.parseDouble(br.readLine()) / 100;

        double[] A = new double[19];
        double[] B = new double[19];

        A[0] = 1;
        B[0] = 1;

        for (int i = 1; i < 19; i++) {
            double[] tA = new double[19];
            double[] tB = new double[19];

            for (int j = 0; j < i; j++) {
                tA[j] += A[j] * (1 - a);
                tB[j] += B[j] * (1 - b);
                tA[j + 1] += A[j] * a;
                tB[j + 1] += B[j] * b;
            }

            A = tA;
            B = tB;
        }

        double pa = 1 - A[2] - A[3] - A[5] - A[7] - A[11] - A[13] - A[17];
        double pb = 1 - B[2] - B[3] - B[5] - B[7] - B[11] - B[13] - B[17];

        System.out.println(1 - pa * pb);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DNA발견_2806 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String dna = br.readLine();

        int[] A = new int[n + 1];
        int[] B = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (dna.charAt(i - 1) == 'A') {
                A[i] = A[i - 1];
                B[i] = Math.min(A[i - 1], B[i - 1]) + 1;
            } else {
                A[i] = Math.min(A[i - 1], B[i - 1]) + 1;
                B[i] = B[i - 1];
            }
        }

        System.out.println(A[n]);
    }
}
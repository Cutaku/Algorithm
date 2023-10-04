package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 피자판매_2632 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int required = Integer.parseInt(br.readLine());

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        int[] A = new int[2 * n + 1];
        int[] B = new int[2 * m + 1];

        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(br.readLine());
            A[i + n] = A[i];
        }

        for (int i = 1; i <= 2 * n; i++)  A[i] += A[i - 1];

        for (int i = 1; i <= m; i++) {
            B[i] = Integer.parseInt(br.readLine());
            B[i + m] = B[i];
        }

        for (int i = 1; i <= 2 * m; i++) B[i] += B[i - 1];

        int[] sumA = new int[n * n - n + 2];
        int[] sumB = new int[m * m - m + 2];

        int a = 0;
        int b = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sumA[a++] = A[j + i] - A[j];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < m; j++) {
                sumB[b++] = B[j + i] - B[j];
            }
        }

        sumA[sumA.length - 1] = A[n];
        sumB[sumB.length - 1] = B[m];

        Arrays.sort(sumA);
        Arrays.sort(sumB);

        a = 0;
        b = sumB.length - 1;

        int count = 0;

        while (a < sumA.length && b >= 0) {
            int sum = sumA[a] + sumB[b];

            if (sum < required) {
                a++;
            } else if (sum > required) {
                b--;
            } else {
                int a2 = a, b2 = b;

                while (a < sumA.length && sumA[a] == sumA[a2]) a++;
                while (b >= 0 && sumB[b] == sumB[b2]) b--;

                count += (a - a2) * (b2 - b);
            }
        }

        System.out.println(count);
    }
}
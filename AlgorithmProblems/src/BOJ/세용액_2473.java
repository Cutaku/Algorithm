package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 세용액_2473 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] solutions = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(solutions);

        long min = Math.abs(solutions[0] + solutions[1] + solutions[n - 1]);
        int x = 0, y = 1, z = n - 1;

        boolean fin = false;

        for (int i = 0; i < n - 2; i++) {
            if (fin) break;

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                long sum = solutions[i] + solutions[j] + solutions[k];

                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    x = i;
                    y = j;
                    z = k;
                }

                if (sum == 0) {
                    fin = true;
                    break;
                }

                if (sum > 0) k--;
                else j++;
            }
        }

        System.out.println(solutions[x] + " " + solutions[y] + " " + solutions[z]);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 용액_2467 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] solutions = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(solutions);

        int i = 0;
        int j = n - 1;

        int x = i;
        int y = j;
        int min = Math.abs(solutions[i] + solutions[j]);

        while (i < j) {
            if (min > Math.abs(solutions[i] + solutions[j])) {
                x = i;
                y = j;
                min = Math.abs(solutions[i] + solutions[j]);
            }

            if (solutions[i] + solutions[j] > 0) j--;
            else if (solutions[i] + solutions[j] < 0) i++;
            else break;
        }

        System.out.println(solutions[x] + " " + solutions[y]);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일학년_5557 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long[] count = new long[21];
        count[numbers[0]] = 1;

        for (int i = 1; i < n - 1; i++) {
            long[] temp = new long[21];

            for (int j = 0; j < 21; j++) {
                if (count[j] == 0) continue;

                if (j + numbers[i] < 21) temp[j + numbers[i]] += count[j];
                if (j >= numbers[i]) temp[j - numbers[i]] += count[j];
            }

            count = temp;
        }

        System.out.println(count[numbers[n - 1]]);
    }
}
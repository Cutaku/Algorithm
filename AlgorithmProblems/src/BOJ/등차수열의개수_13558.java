package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 등차수열의개수_13558 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long[] left = new long[30001];
        long[] right = new long[30001];

        left[arr[0]]++;

        for (int i = 2; i < n; i++) {
            right[arr[i]]++;
        }

        long count = 0;

        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j <= Math.min(arr[i], 30000 - arr[i]); j++) {
                count += left[arr[i] - j] * right[arr[i] + j];
                if (j > 0) count += left[arr[i] + j] * right[arr[i] - j];
            }

            left[arr[i]]++;
            right[arr[i + 1]]--;
        }

        System.out.println(count);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

public class 주사위쌓기_2116 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Integer> opposite = Map.of(0, 5, 5, 0, 1, 3, 3, 1, 2, 4, 4, 2);

        int n = Integer.parseInt(br.readLine());

        int[] above = {1, 2, 3, 4, 5, 6};
        int[] sum = {0, 0, 0, 0, 0, 0};

        for (int i = 0; i < n; i++) {
            int[] dice = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < 6; j++) {
                int ind = indexOf(dice, above[j]);
                int ab = dice[opposite.get(ind)];

                if (above[j] < 6 && ab < 6) sum[j] += 6;
                else if (above[j] < 5 || ab < 5) sum[j] += 5;
                else sum[j] += 4;

                above[j] = ab;
            }
        }

        int max = 0;

        for (int s : sum) {
            max = Math.max(max, s);
        }

        System.out.println(max);
    }

    static int indexOf(int[] arr, int num) {

        for (int i = 0; i < 6; i++) {
            if (arr[i] == num) return i;
        }

        return -1;
    }
}
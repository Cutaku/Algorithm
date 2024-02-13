package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 링크와스타트_15661 {
    static int n ,m;
    static int[][] abilities;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = 1 << n;

        abilities = new int[n][];
        for (int i = 0; i < n; i++) {
            abilities[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < m / 2; i++) {
            min = Math.min(min, findDif(i));
        }

        System.out.println(min);
    }

    static int findDif(int k) {

        int[] left = new int[n];
        int[] right = new int[n];

        int l = 0;
        int r = 0;

        for (int i = 0; i < n; i++) {
            if (k % 2 == 1) left[l++] = i;
            else right[r++] = i;

            k /= 2;
        }

        return Math.abs(score(left, l) - score(right, r));

    }

    static int score(int[] arr, int l) {

        int sum = 0;

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                sum += abilities[arr[i]][arr[j]];
            }
        }

        return sum;
    }
}
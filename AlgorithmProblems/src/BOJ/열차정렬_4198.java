package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 열차정렬_4198 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());

        int[] increase = new int[n];
        int[] decrease = new int[n];

        Arrays.fill(increase, Integer.MAX_VALUE);
        Arrays.fill(decrease, Integer.MIN_VALUE);

        int max = 0;

        for (int i = n - 1; i >= 0; i--) {
            int s1 = 0, e1 = n - 1, s2 = 0, e2 = n - 1;

            if (arr[i] < increase[0]) {
                e1 = 0;
            } else {
                while (e1 - s1 > 1) {
                    int m = (e1 + s1) >> 1;

                    if (increase[m] > arr[i]) e1 = m;
                    else s1 = m;
                }
            }

            if (arr[i] > decrease[0]) {
                e2 = 0;
            } else {
                while (e2 - s2 > 1) {
                    int m = (e2 + s2) >> 1;

                    if (decrease[m] < arr[i]) e2 = m;
                    else s2 = m;
                }
            }

            increase[e1] = arr[i];
            decrease[e2] = arr[i];

            max = Math.max(max, e1 + e2 + 1);
        }

        System.out.println(max);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 조별과제_30960 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] students = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) students[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(students);

        long[] odd = new long[n / 2 + 1];
        long[] even = new long[n / 2 + 1];

        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0) even[i / 2 + 1] = even[i / 2] + students[i + 1] - students[i];
            else odd[i / 2 + 1] = odd[i / 2] + students[i + 1] - students[i];
        }

        long min = Long.MAX_VALUE;

        for (int i = 1; i <= n / 2; i++) {
            min = Math.min(min, even[i] + odd[n / 2] - odd[i - 1]);
        }

        System.out.println(min);
    }
}
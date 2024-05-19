package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나눌수있는부분수열_3673 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int c = Integer.parseInt(br.readLine());

        int d, n;
        int sum;

        int[] remainder;

        while (c-- > 0) {
            st = new StringTokenizer(br.readLine());

            d = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            sum = 0;

            remainder = new int[d];
            remainder[0] = 1;

            st = new StringTokenizer(br.readLine());

            long count = 0;

            for (int i = 0; i < n; i++) {
                sum = (sum + Integer.parseInt(st.nextToken())) % d;

                count += remainder[sum]++;
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
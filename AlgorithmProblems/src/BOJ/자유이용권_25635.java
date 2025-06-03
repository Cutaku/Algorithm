package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 자유이용권_25635 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long sum = 0;
        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());

            sum += a;
            max = Math.max(max, a);
        }

        long left = sum - max;

        if (left < max) {
            System.out.println(left * 2 + 1);
        } else {
            System.out.println(sum);
        }
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 생일선물_12892 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());

        int[][] presents = new int[n][];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            presents[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(presents, Comparator.comparingInt(a -> a[0]));

        int s = 0, e = 1;
        long sum = presents[0][1];
        long max = sum;

        while (e < n) {
            if (presents[e][0] - presents[s][0] < d) {
                sum += presents[e++][1];
                max = Math.max(max, sum);
            } else {
                sum -= presents[s++][1];
            }
        }

        System.out.println(max);
    }
}
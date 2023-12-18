package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 우체국_2141 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        int[][] villages = new int[n][];

        for (int i = 0; i < n; i++) {
            villages[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Arrays.sort(villages, Comparator.comparingInt(v -> v[0]));

        long[] count = new long[n];

        count[0] = villages[0][1];

        for (int i = 1; i < n; i++) {
            count[i] = count[i - 1] + villages[i][1];
        }

        long half = (count[n - 1] + 1) / 2;

        if (villages[0][1] >= half) {
            System.out.println(villages[0][0]);
            return;
        }

        int l = 0;
        int r = n - 1;

        while (r - l > 1) {
            int m = (l + r) / 2;

            if (count[m] < half) l = m;
            else r = m;
        }

        System.out.println(villages[r][0]);
    }
}
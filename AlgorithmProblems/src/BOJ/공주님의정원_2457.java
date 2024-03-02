package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공주님의정원_2457 {
    static int[] dates = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] flowers = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            flowers[i][0] = toDates(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            flowers[i][1] = toDates(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(flowers, (f1, f2) -> f1[0] == f2[0] ? f2[1] - f1[1] : f1[0] - f2[0]);

        int s = 0;
        int count = 0;
        int max = toDates(3, 1);
        int last = toDates(3, 1);

        while (s < n) {
            if (max < flowers[s][0]) {
                System.out.println(0);
                return;
            }

            do {
                max = Math.max(max, flowers[s++][1]);
            } while (s < n && flowers[s][0] <= last);

            count++;

            if (max > toDates(11, 30)) {
                System.out.println(count);
                return;
            }

            last = max;
        }

        System.out.println(0);
    }

    static int toDates(int month, int day) {

        int res = day;
        for (int i = 1; i < month; i++) res += dates[i];

        return res;
    }
}
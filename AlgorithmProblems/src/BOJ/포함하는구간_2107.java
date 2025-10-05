package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 포함하는구간_2107 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] intervals = new int[n][];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            intervals[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int max = 0;

        for (int i = 0; i < n - 1; i++) {
            int cnt = 0;

            for (int j = i + 1; j < n; j++) {
                if (intervals[i][1] < intervals[j][0]) break;
                if (intervals[i][1] > intervals[j][1]) cnt++;
            }

            max =  Math.max(max, cnt);
        }

        System.out.println(max);
    }
}
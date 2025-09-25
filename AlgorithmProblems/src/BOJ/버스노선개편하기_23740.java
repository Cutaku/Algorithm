package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 버스노선개편하기_23740 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] buses = new int[n][];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            buses[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(buses, Comparator.comparingInt(a -> a[0]));

        int s = buses[0][0];
        int e = buses[0][1];
        int c = buses[0][2];

        List<int[]> ans = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if (e < buses[i][0]) {
                ans.add(new int[]{s, e, c});

                s = buses[i][0];
                e = buses[i][1];
                c = buses[i][2];
            } else {
                e = Math.max(e, buses[i][1]);
                c = Math.min(c, buses[i][2]);
            }
        }

        ans.add(new int[]{s, e, c});

        StringBuilder sb = new StringBuilder();

        sb.append(ans.size()).append("\n");
        for (int[] a : ans) sb.append(a[0]).append(" ").append(a[1]).append(" ").append(a[2]).append("\n");

        System.out.println(sb);
    }
}
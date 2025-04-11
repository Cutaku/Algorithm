package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 연료채우기_1826 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] stations = new int[n][];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            stations[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(stations, Comparator.comparingInt(a -> a[0]));

        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken()), p = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a[1]));

        int idx = 0;
        int cnt = 0;

        while (p < l) {
            while (idx < n && stations[idx][0] <= p) {
                pq.add(stations[idx++]);
            }

            if (pq.isEmpty()) {
                System.out.println(-1);
                return;
            }

            p += pq.poll()[1];
            cnt++;
        }

        System.out.println(cnt);
    }
}
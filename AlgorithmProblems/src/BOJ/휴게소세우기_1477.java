package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 휴게소세우기_1477 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] serviceAreas = new int[n + 2];
        serviceAreas[n + 1] = l;

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            serviceAreas[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(serviceAreas);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a[2]));

        for (int i = 1; i < n + 2; i++) {
            int dif = serviceAreas[i] - serviceAreas[i - 1];
            pq.add(new int[]{dif, 1, dif});
        }

        for (int i = 0; i < m; i++) {
            int[] dif = pq.poll();

            dif[1]++;

            dif[2] = (int) Math.ceil((double) dif[0] / dif[1]);

            pq.add(dif);
        }

        System.out.println(pq.peek()[2]);
    }
}
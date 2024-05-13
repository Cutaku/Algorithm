package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 보석도둑_1202 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> jewels = new PriorityQueue<>(Comparator.comparingInt(j -> j[0]));

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            jewels.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int[] bags = new int[k];

        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);

        long ans = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(j -> -j[1]));

        for (int i = 0; i < k; i++) {
            while (!jewels.isEmpty() && jewels.peek()[0] <= bags[i]) {
                pq.add(jewels.poll());
            }

            if (!pq.isEmpty()) {
                ans += pq.poll()[1];
            }
        }

        System.out.println(ans);
    }
}
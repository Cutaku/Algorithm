package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 통학버스_2513 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> left = new PriorityQueue<>(Comparator.comparingInt(a -> -a[1]));
        PriorityQueue<int[]> right = new PriorityQueue<>(Comparator.comparingInt(a -> -a[1]));

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (p < s) {
                left.add(new int[]{c, s - p});
            } else if (p > s) {
                right.add(new int[]{c, p - s});
            }
        }

        int ans = 0;

        int r = 0;

        while (!left.isEmpty()) {
            int[] p = left.poll();

            int q = Math.min(r, p[0]);

            r -= q;
            p[0] -= q;

            ans += (p[0] + k - 1) / k * p[1];
            r += (k - p[0] % k) % k;
        }

        r = 0;

        while (!right.isEmpty()) {
            int[] p = right.poll();

            int q = Math.min(r, p[0]);

            r -= q;
            p[0] -= q;

            ans += (p[0] + k - 1) / k * p[1];
            r += (k - p[0] % k) % k;
        }

        System.out.println(ans * 2);
    }
}
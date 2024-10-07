package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 여왕벌_10836 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> mh = new PriorityQueue<>();
        PriorityQueue<Integer> ml = new PriorityQueue<>();
        PriorityQueue<Integer> wh = new PriorityQueue<>();
        PriorityQueue<Integer> wl = new PriorityQueue<>();

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int h1 = Integer.parseInt(st1.nextToken());
            int h2 = Integer.parseInt(st2.nextToken());

            if (h1 > 0) mh.add(h1);
            else ml.add(-h1);

            if (h2 > 0) wh.add(h2);
            else wl.add(-h2);
        }

        int ans = 0;

        while (!ml.isEmpty() && !wh.isEmpty()) {
            if (wh.peek() < ml.poll()) {
                ans++;
                wh.poll();
            }
        }

        while (!wl.isEmpty() && !mh.isEmpty()) {
            if (mh.peek() < wl.poll()) {
                ans++;
                mh.poll();
            }
        }

        System.out.println(ans);
    }
}
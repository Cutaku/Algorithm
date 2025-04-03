package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 웨이팅_30054 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] time = new boolean[300001];
        int[] arrival = new int[200001];
        boolean[] finish = new boolean[200001];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        PriorityQueue<int[]> waiting = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int c = 0;

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());

            if (t1 == t2) {
                time[t1] = true;
                c++;
            }
            else {
                pq.add(new int[]{t1, t2});
            }
        }

        int max = 0;
        int t = 1;

        while (c < n) {
            while (!pq.isEmpty() && pq.peek()[1] == t) {
                int[] poll = pq.poll();
                arrival[poll[0]] = t;
                waiting.add(poll);
            }

            if (time[t]) {
                t++;
                continue;
            }

            while (!time[t] && !waiting.isEmpty()) {
                if (t <= 200000 && arrival[t] > 0 && !finish[t]) {
                    finish[t] = true;
                    time[t] = true;

                    max = Math.max(max, t - arrival[t]);
                    c++;

                    break;
                }

                while (!waiting.isEmpty()) {
                    int[] poll = waiting.poll();

                    if (!finish[poll[0]]) {
                        finish[poll[0]] = true;
                        time[t] = true;

                        max = Math.max(max, t - poll[1]);
                        c++;

                        break;
                    }
                }
            }

            t++;
        }

        System.out.println(max);
    }
}
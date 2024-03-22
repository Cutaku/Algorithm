package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트럭_13335 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Queue<int[]> bridge = new ArrayDeque<>();

        int time = 0;
        int total = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int truck = Integer.parseInt(st.nextToken());

            if (!bridge.isEmpty() && time - bridge.peek()[0] == w) {
                total -= bridge.poll()[1];
            }

            while (total + truck > l) {
                int[] poll = bridge.poll();
                time += w - time + poll[0];
                total -= poll[1];
            }

            bridge.add(new int[]{time++, truck});
            total += truck;
        }

        time += w;

        System.out.println(time);
    }
}
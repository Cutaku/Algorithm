package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 피자오븐_19940 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] count = new int[61][];
        int[] buttons = {60, 10, -10, 1, -1};

        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        count[0] = new int[]{0, 0, 0, 0, 0};

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 4; i >= 0; i--) {
                int next = now + buttons[i];

                if (next < 0 || next > 60 || count[next] != null) continue;

                count[next] = count[now].clone();
                count[next][i]++;

                q.add(next);
            }
        }

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int time = Integer.parseInt(br.readLine());

            int[] ans = count[time % 60].clone();
            ans[0] += time / 60;

            for (int i = 0; i < 5; i++) sb.append(ans[i]).append(" ");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
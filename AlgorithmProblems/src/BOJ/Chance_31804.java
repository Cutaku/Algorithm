package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Chance_31804 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

        Queue<int[]> q1 = new ArrayDeque<>();
        Queue<int[]> q2 = new ArrayDeque<>();

        boolean[][] v = new boolean[b + 1][2];
        int cnt = 0;

        q1.add(new int[]{a, 0});
        v[a][0] = true;

        while (!q1.isEmpty()) {
            int[] now = q1.poll();
            int num = now[0], jump = now[1];

            if (num == b) {
                System.out.println(cnt);
                return;
            }

            if (!v[num + 1][jump]) {
                q2.add(new int[]{num + 1, jump});
                v[num + 1][jump] = true;
            }

            if (2 * num <= b && !v[2 * num][jump]) {
                q2.add(new int[]{2 * num, jump});
                v[2 * num][jump] = true;
            }

            if (jump == 0 && 10 * num <= b && !v[10 * num][jump]) {
                q2.add(new int[]{10 * num, 1});
                v[10 * num][1] = true;
            }

            if (q1.isEmpty()) {
                Queue<int[]> tmp = q1;
                q1 = q2;
                q2 = tmp;

                cnt++;
            }
        }
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 치즈_2636 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] hw = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int h = hw[0], w = hw[1];

        int[][] board = new int[h][];
        for (int i = 0; i < h; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        Set<Integer> v = new HashSet<>();

        q1.add(0);

        int count = -1;
        int last = 0;

        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!q1.isEmpty()) {
            int n = q1.poll();
            int r = n / w;
            int c = n % w;

            for (int[] d : D) {
                int x = r + d[0];
                int y = c + d[1];
                int m = x * w + y;

                if (x < 0 || y < 0 || x >= h || y >= w || !v.add(m)) continue;

                if (board[x][y] == 1) q2.add(m);
                else q1.add(m);
            }

            if (q1.isEmpty()) {
                Queue<Integer> t = q1;
                q1 = q2;
                q2 = t;

                if (!q1.isEmpty()) last = q1.size();

                count++;
            }
        }

        System.out.println(count);
        System.out.println(last);
    }
}
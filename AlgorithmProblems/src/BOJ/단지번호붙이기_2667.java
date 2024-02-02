package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class 단지번호붙이기_2667 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) map[i] = br.readLine().toCharArray();

        Queue<int[]> q = new ArrayDeque<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int[][] D = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '0') continue;
                map[i][j] = '0';

                int count = 1;

                q.add(new int[]{i, j});

                while (!q.isEmpty()) {
                    int[] now = q.poll();

                    for (int[] d : D) {
                        int x = now[0] + d[0];
                        int y = now[1] + d[1];

                        if (x < 0 || y < 0 || x >= n || y >= n || map[x][y] == '0') continue;

                        map[x][y] = '0';
                        count++;

                        q.add(new int[]{x, y});
                    }

                }

                pq.add(count);
            }
        }

        System.out.println(pq.size());
        while (!pq.isEmpty()) System.out.println(pq.poll());
    }
}
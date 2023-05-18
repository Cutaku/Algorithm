package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 움직이는미로탈출_16954 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> walls = new HashSet<>();

        for (int i = 0; i < 8; i++) {
            String line = br.readLine();

            for (int j = 0; j < 8; j++) {
                if (line.charAt(j) == '#') walls.add(8 * i  + j);
            }
        }

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q1.add(56);


        int[] D = new int[]{-9, -8, -7, -1, 0, 1, 7, 8, 9};

        while (!q1.isEmpty()) {
            int now = q1.poll();

            if (now == 7) {
                System.out.println(1);
                return;
            }

            if (!walls.contains(now)) {
                for (int d : D) {
                    int next = now + d;

                    if (next < 0 || next > 63 || walls.contains(next) || !close(now, next)) continue;

                    q2.add(next);
                }
            }

            if (q1.isEmpty()) {
                q1 = q2;
                q2 = new LinkedList<>();

                Set<Integer> temp = new HashSet<>();

                for (int wall : walls) {
                    if (wall < 56) {
                        temp.add(wall + 8);
                    }
                }

                walls = temp;
            }
        }

        System.out.println(0);
    }

    public static boolean close(int n, int m) {

        int x1 = n / 8;
        int y1 = n % 8;
        int x2 = m / 8;
        int y2 = m % 8;

        return Math.abs(x1 - x2) + Math.abs(y1 - y2) < 3;
    }
}
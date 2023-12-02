package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 배달_1175 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        char[][] classroom = new char[n][];
        for (int i = 0; i < n; i++) classroom[i] = br.readLine().toCharArray();

        boolean[][][][] v = new boolean[n][m][3][5];

        Queue<Minsik> q1 = new LinkedList<>();
        Queue<Minsik> q2 = new LinkedList<>();

        int[][] target = new int[2][];

        int[][] D = new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (classroom[i][j] == 'S') {
                    q1.add(new Minsik(i, j, 0, false, false));
                    v[i][j][0][0] = true;
                } else if (classroom[i][j] == 'C') {
                    if (target[0] == null) target[0] = new int[]{i, j};
                    else target[1] = new int[]{i, j};
                }
            }
        }

        int count = 0;

        while (!q1.isEmpty()) {
            Minsik minsik = q1.poll();

            if (minsik.v1 && minsik.v2) {
                System.out.println(count);
                return;
            }

            for (int i = 1; i < 5; i++) {
                if (minsik.d == i) continue;

                int x = minsik.x + D[i][0];
                int y = minsik.y + D[i][1];

                if (x < 0 || y < 0 || x >= n || y >= m || classroom[x][y] == '#') continue;

                if (!minsik.v1 && !minsik.v2 && v[x][y][0][i]) continue;

                if (minsik.v1 && v[x][y][1][i]) continue;
                if (minsik.v2 && v[x][y][2][i]) continue;

                v[x][y][0][i] = true;
                if (minsik.v1) v[x][y][1][i] = true;
                if (minsik.v2) v[x][y][2][i] = true;

                Minsik next = new Minsik(x, y, i, minsik.v1, minsik.v2);

                if (target[0][0] == x && target[0][1] == y) next.v1 = true;
                if (target[1][0] == x && target[1][1] == y) next.v2 = true;

                q2.add(next);
            }

            if (q1.isEmpty()) {
                q1 = q2;
                q2 = new LinkedList<>();
                count++;
            }
        }

        System.out.println(-1);
    }

    public static class Minsik {

        int x;
        int y;
        int d;

        boolean v1;
        boolean v2;

        public Minsik(int x, int y, int d, boolean v1, boolean v2) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.v1 = v1;
            this.v2 = v2;
        }
    }
}
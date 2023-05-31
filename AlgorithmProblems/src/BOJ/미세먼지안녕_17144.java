package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 미세먼지안녕_17144 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] rct = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = rct[0], c = rct[1], t = rct[2];

        int[][] room = new int[r][];
        for (int i = 0; i < r; i++) room[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < t; i++) {
            spread(room);
            airClean(room);
        }

        int totalDust = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                totalDust += Math.max(0, room[i][j]);
            }
        }

        System.out.println(totalDust);
    }

    public static void spread(int[][] room) {

        int r = room.length;
        int c = room[0].length;

        int[][] D = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int[][] movingDusts = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (room[i][j] < 5) continue;

                int movingDust = room[i][j] / 5;

                for (int[] d : D) {
                    int x = i + d[0];
                    int y = j + d[1];

                    if (x < 0 || y < 0 || x >= r || y >= c || room[x][y] == -1) continue;

                    room[i][j] -= movingDust;
                    movingDusts[x][y] += movingDust;
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                room[i][j] += movingDusts[i][j];
            }
        }
    }

    public static void airClean(int[][] room) {

        int r = room.length;
        int c = room[0].length;

        int p = 0;
        while (room[p][0] > -1) p++;

        for (int i = p - 1; i > 0; i--) room[i][0] = room[i - 1][0];
        for (int i = 0; i < c - 1; i++) room[0][i] = room[0][i + 1];
        for (int i = 0; i < p; i++) room[i][c - 1] = room[i + 1][c - 1];
        for (int i = c - 1; i > 1; i--) room[p][i] = room[p][i - 1];
        room[p][1] = 0;

        for (int i = p + 2; i < r - 1; i++) room[i][0] = room[i + 1][0];
        for (int i = 0; i < c - 1; i++) room[r - 1][i] = room[r - 1][i + 1];
        for (int i = r - 1; i > p + 1; i--) room[i][c - 1] = room[i - 1][c - 1];
        for (int i = c - 1; i > 1; i--) room[p + 1][i] = room[p + 1][i - 1];
        room[p + 1][1] = 0;
    }
}
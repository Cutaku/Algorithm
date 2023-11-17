package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PuyoPuyo_11559 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] field = new char[12][];
        for (int i = 0; i < 12; i++) field[i] = br.readLine().toCharArray();

        int count = 0;

        while (bomb(field)) {
            count++;

            down(field);
        }

        System.out.println(count);
    }

    public static boolean bomb(char[][] field) {

        boolean result = false;

        boolean[][] v = new boolean[12][6];


        int[][] D = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                Queue<int[]> q1 = new LinkedList<>();
                Queue<int[]> q2 = new LinkedList<>();

                if (v[i][j]) continue;

                v[i][j] = true;

                if (field[i][j] == '.') continue;

                char c = field[i][j];

                q1.add(new int[]{i, j});

                while (!q1.isEmpty()) {
                    int[] now = q1.poll();

                    for (int[] d : D) {
                        int x = now[0] + d[0];
                        int y = now[1] + d[1];

                        if (x < 0 || y < 0 || x >= 12 || y >= 6 || v[x][y] || field[x][y] != c) continue;

                        v[x][y] = true;

                        q1.add(new int[]{x, y});
                    }

                    q2.add(now);
                }

                if (q2.size() > 3) {
                    result = true;

                    while (!q2.isEmpty()) {
                        int[] p = q2.poll();

                        field[p[0]][p[1]] = '.';
                    }
                }
            }
        }

        return result;
    }

    public static void down(char[][] field) {

        for (int i = 0; i < 6; i++) {
            List<Character> list = new ArrayList<>();

            for (int j = 11; j >= 0 ; j--) {
                if (field[j][i] != '.') list.add(field[j][i]);
            }

            for (int j = 0; j < 12; j++) {
                if (j < list.size()) {
                    field[11 - j][i] = list.get(j);
                } else {
                    field[11 - j][i] = '.';
                }
            }
        }
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 감시피하기_18428 {
    static int n;
    static char[][] map;
    static List<int[]> blanks;
    static List<int[]> teachers;
    static int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        blanks = new ArrayList<>();
        teachers = new ArrayList<>();

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0);

                if (map[i][j] == 'X') blanks.add(new int[]{i, j});
                else if (map[i][j] == 'T') teachers.add(new int[]{i, j});
            }
        }

        System.out.println(dfs(0, 0) ? "YES" : "NO");
    }

    static boolean dfs(int d, int c) {

        if (c == 3) return check();
        if (d == blanks.size()) return false;

        if (dfs(d + 1, c)) return true;

        int[] b = blanks.get(d);

        map[b[0]][b[1]] = 'O';
        if (dfs(d + 1, c + 1)) return true;
        map[b[0]][b[1]] = 'X';

        return false;
    }

    static boolean check() {

        Queue<int[]> q = new ArrayDeque<>();

        for (int[] t : teachers) {
            for (int[] d : D) {
                int x = t[0], y = t[1];

                while (x >= 0 && y >= 0 && x < n && y < n && map[x][y] != 'O') {
                    if (map[x][y] == 'S') return false;

                    x += d[0];
                    y += d[1];
                }
            }
        }


        return true;
    }
}
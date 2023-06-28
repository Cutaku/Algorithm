package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 감시_15683 {
    static int n;
    static int m;
    static int[][] room;
    static List<int[]> cctv;
    static int min;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = nm[0];
        m = nm[1];

        room = new int[n][];
        for (int i = 0; i < n; i++) room[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        cctv = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (room[i][j] > 0 && room[i][j] < 6) cctv.add(new int[]{i, j, room[i][j]});
            }
        }

        cctv.sort(Comparator.comparingInt(c -> c[2]));

        min = 100;

        dfs(0);

        System.out.println(min);
    }

    public static void dfs(int k) {

        if (k == cctv.size()) {
            min = Math.min(min, count());
            return;
        }

        int[] c = cctv.get(k);

        int[][] temp = copy(room);

        if (c[2] == 1 || c[2] == 3 || c[2] == 4) {
            for (int i = 1; i < 5; i++) {
                findObserved(c[0], c[1], c[2], i);
                dfs(k + 1);
                room = copy(temp);
            }
        } else if (c[2] == 2) {
            for (int i = 1; i < 3; i++) {
                findObserved(c[0], c[1], c[2], i);
                dfs(k + 1);
                room = copy(temp);
            }
        } else {
            findObserved(c[0], c[1], c[2], 0);
            dfs(k + 1);
            room = copy(temp);
        }
    }

    public static void findObserved(int x, int y, int c, int d) {

        switch (c) {
            case 1:
                if (d == 1) {
                    up(x, y);
                } else if (d == 2) {
                    right(x, y);
                } else if (d == 3) {
                    down(x, y);
                } else {
                    left(x, y);
                }
                break;
            case 2:
                if (d == 1) {
                    up(x, y);
                    down(x, y);
                } else if (d == 2) {
                    right(x, y);
                    left(x, y);
                }
                break;
            case 3:
                if (d == 1) {
                    up(x, y);
                    right(x, y);
                } else if (d == 2) {
                    right(x, y);
                    down(x, y);
                } else if (d == 3) {
                    down(x, y);
                    left(x, y);
                } else {
                    left(x, y);
                    up(x, y);
                }
                break;
            case 4:
                if (d == 1) {
                    up(x, y);
                    right(x, y);
                    down(x, y);
                } else if (d == 2) {
                    right(x, y);
                    down(x, y);
                    left(x, y);
                } else if (d == 3) {
                    down(x, y);
                    left(x, y);
                    up(x, y);
                } else {
                    left(x, y);
                    up(x, y);
                    right(x, y);
                }
                break;
            default:
                up(x, y);
                right(x, y);
                down(x, y);
                left(x, y);
        }
    }

    private static void left(int x, int y) {
        for (int i = y - 1; i >= 0; i--) {
            if (room[x][i] == 0) room[x][i] = 7;
            else if (room[x][i] == 6) break;
        }
    }

    private static void down(int x, int y) {
        for (int i = x + 1; i < n; i++) {
            if (room[i][y] == 0) room[i][y] = 7;
            else if (room[i][y] == 6) break;
        }
    }

    private static void right(int x, int y) {
        for (int i = y + 1; i < m; i++) {
            if (room[x][i] == 0) room[x][i] = 7;
            else if (room[x][i] == 6) break;
        }
    }

    private static void up(int x, int y) {
        for (int i = x - 1; i >= 0 ; i--) {
            if (room[i][y] == 0) room[i][y] = 7;
            else if (room[i][y] == 6) break;
        }
    }

    public static int[][] copy(int[][] room) {

        int[][] result = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               result[i][j] = room[i][j];
            }
        }

        return result;
    }

    public static int count() {

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (room[i][j] == 0) count++;
            }
        }

        return count;
    }
}
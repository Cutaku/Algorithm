package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 게임_1103 {
    static int n;
    static int m;
    static char[][] board;
    static boolean[][] visited;
    static int[][] count;
    static int[][] D = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = nm[0];
        m = nm[1];

        board = new char[n][];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        visited = new boolean[n][m];

        count = new int[n][m];

        int ans = dfs(0, 0, 1);

        System.out.println(ans);
    }

    public static int dfs(int x, int y, int c) {

        if (visited[x][y]) return -1;

        if (count[x][y] > 0) return c + count[x][y] - 1;

        visited[x][y] = true;

        int max = 0;

        int l = board[x][y] - '0';

        boolean flag = false;

        for (int[] d : D) {
            int nx = x + d[0] * l;
            int ny = y + d[1] * l;

            if (nx < 0 || ny < 0 || nx >= n || ny >= m || board[nx][ny] == 'H') continue;

            flag = true;

            int t = dfs(nx, ny, c + 1);

            visited[nx][ny] = false;

            if (t == -1) return -1;

            max = Math.max(max, t);
        }

        if (flag) {
            count[x][y] = max - c + 1;
            return max;
        } else {
            count[x][y] = 1;
            return c;
        }
    }
}
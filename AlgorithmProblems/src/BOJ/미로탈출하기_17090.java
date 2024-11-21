package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 미로탈출하기_17090 {
    static int n, m;
    static char[][] maze;
    static boolean[][] visit;
    static Boolean[][] escape;
    static Map<Character, int[]> direction;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new char[n][];
        for (int i = 0; i < n; i++) maze[i] = br.readLine().toCharArray();

        visit = new boolean[n][m];
        escape = new Boolean[n][m];

        direction = new HashMap<>();
        direction.put('U', new int[]{-1, 0});
        direction.put('D', new int[]{1, 0});
        direction.put('L', new int[]{0, -1});
        direction.put('R', new int[]{0, 1});

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (escape[i][j] == null) escape[i][j] = escape(i, j);
                if (escape[i][j]) count++;
            }
        }

        System.out.println(count);
    }

    static boolean escape(int r, int c) {

        if (r < 0 || c < 0 || r >= n || c >= m) return true;

        if (escape[r][c] != null) return escape[r][c];

        if (visit[r][c]) return false;

        visit[r][c] = true;

        int[] d = direction.get(maze[r][c]);

        return escape[r][c] = escape(r + d[0], c + d[1]);
    }
}
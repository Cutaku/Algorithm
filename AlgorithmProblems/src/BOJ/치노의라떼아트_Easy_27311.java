package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치노의라떼아트_Easy_27311 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        a: while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());

            boolean[][] coffee = new boolean[r][c];

            for (int i = 0; i < r; i++) {
                String line = br.readLine();

                for (int j = 0; j < c; j++) {
                    coffee[i][j] = line.charAt(j) == '#';
                }
            }


            boolean flag = false;

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (!coffee[i][j]) continue;

                    if (flag) {
                        sb.append("0\n");
                        continue a;
                    }

                    flag = true;

                    List<int[]> creams = new ArrayList<>();
                    int idx = 0;

                    creams.add(new int[] {i, j});
                    coffee[i][j] = false;

                    while (idx < creams.size()) {
                        int[] now = creams.get(idx++);

                        for (int[] d : D) {
                            int x = now[0] + d[0];
                            int y = now[1] + d[1];

                            if (x < 0 || y < 0 || x >= r || y >= c || !coffee[x][y]) continue;

                            creams.add(new int[]{x, y});
                            coffee[x][y] = false;
                        }
                    }

                    if (!isHeart(creams)) {
                        sb.append("0\n");
                        continue a;
                    }
                }
            }

            sb.append(flag ? "1\n" : "0\n");
        }

        System.out.println(sb);
    }

    static boolean isHeart(List<int[]> creams) {

        int minX = 100, minY = 100, maxX = 0, maxY = 0;

        for (int[] p : creams) {
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
            maxX = Math.max(maxX, p[0]);
            maxY = Math.max(maxY, p[1]);
        }

        if (maxX - minX != maxY - minY) return false;

        int l = maxX - minX + 1;

        boolean[][] heart =  new boolean[l][l];

        for (int[] p : creams) {
            heart[p[0] - minX][p[1] - minY] = true;
        }

        int cnt = 0;
        if (heart[0][0]) cnt++;
        if (heart[0][l - 1]) cnt++;
        if (heart[l - 1][0]) cnt++;
        if (heart[l - 1][l - 1]) cnt++;

        if (cnt != 3)  return false;

        List<int[]> blanks = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (!heart[i][j]) blanks.add(new int[]{i, j});
            }
        }

        return isSquare(blanks);
    }

    static boolean isSquare(List<int[]> blanks) {

        int minX = 100, minY = 100, maxX = 0, maxY = 0;

        for (int[] p : blanks) {
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
            maxX = Math.max(maxX, p[0]);
            maxY = Math.max(maxY, p[1]);
        }

        if (maxX - minX != maxY - minY) return false;

        return (maxX - minX + 1) * (maxY - minY + 1) == blanks.size();
    }
}
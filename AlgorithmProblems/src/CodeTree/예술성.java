package CodeTree;

import java.util.*;
import java.io.*;

public class 예술성 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] art = new int[n][];
        for (int i = 0; i < n; i++) {
            art[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int score = getScore(art);
        for (int i = 0; i < 3; i++) {
            rotate(art);
            score += getScore(art);
        }


        System.out.println(score);

    }

    static void rotate(int[][] art) {

        int n = art.length;
        int m = n / 2;

        int[][] temp = new int[n][];
        for (int i = 0; i < n; i++) temp[i] = new int[n];

        for (int i = 0; i < n; i++) {
            temp[m][i] = art[i][m];
            temp[i][m] = art[m][n - i - 1];
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = art[m - 1 - j][i];
                temp[i + m + 1][j] = art[2 * m - j][i];
                temp[i][j + m + 1] = art[m - 1 - j][i + m + 1];
                temp[i + m + 1][j + m + 1] = art[2 * m - j][i + m + 1];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) art[i][j] = temp[i][j];
        }
    }

    static int[][] findGroup(int[][] art) {

        int n = art.length;

        int[][] group = new int[n][];
        for (int i = 0; i < n; i++) group[i] = new int[n];

        Queue<int[]> q = new LinkedList<>();

        int g = 1;

        int[][] D = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (group[i][j] == 0) {
                    group[i][j] = g++;
                    q.add(new int[] {i, j});
                }

                while (!q.isEmpty()) {

                    int[] now = q.poll();
                    int num = art[now[0]][now[1]];

                    for (int[] d : D) {
                        int x = now[0] + d[0];
                        int y = now[1] + d[1];

                        if (x >= 0 && y >= 0 && x < n && y < n && group[x][y] == 0 && art[x][y] == num) {
                            group[x][y] = g - 1;
                            q.add(new int[] {x, y});
                        }
                    }
                }
            }
        }

        return group;
    }

    static int getScore(int[][] art) {

        int n = art.length;
        int[][] group = findGroup(art);

        int[] groupCount = new int[n * n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                groupCount[group[i][j]]++;
            }
        }

        int score = 0;

        int[][] D = new int[][] {{1, 0}, {0, 1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] d : D) {
                    int x = i + d[0];
                    int y = j + d[1];

                    if (x < n && y < n && group[i][j] != group[x][y]) {
                        score += (groupCount[group[i][j]] + groupCount[group[x][y]]) * art[i][j] * art[x][y];
                    }
                }
            }
        }

        return score;
    }
}
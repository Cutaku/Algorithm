package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 고대문명유적탐사 {
    static int[][] board;
    static int[] wallNum;
    static int w;
    static int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        board = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        wallNum = new int[m];
        w = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) wallNum[i] = Integer.parseInt(st.nextToken());

        int c = 0;

        for (int i = 0; i < k; i++) {
            c = count();
            if (c == 0) break;

            sb.append(c).append(" ");
        }

        System.out.println(sb);
    }

    static int count() {

        int[] center = {0, 0, 4};
        List<int[]> remove = new ArrayList<>();

        for (int j = 1; j < 4; j++) {
            for (int i = 1; i < 4; i++) {
                for (int r = 0; r < 4; r++) {
                    rotate(i, j);

                    if (r == 4) break;

                    List<int[]> temp = find();

                    if (remove.size() < temp.size()) {
                        center = new int[]{i, j, r};
                        remove = temp;
                    } else if (remove.size() == temp.size() && r < center[2]) {
                        center = new int[]{i, j, r};
                        remove = temp;
                    }
                }
            }
        }

        for (int i = 0; i < center[2] + 1; i++) {
            rotate(center[0], center[1]);
        }

        int count = 0;

        while (remove.size() > 0) {
            count += remove.size();
            fill(remove);
            remove = find();
        }

        return count;
    }

    static void fill(List<int[]> remove) {

        Collections.sort(remove, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        });

        for (int i = 0; i < remove.size(); i++) {
            int[] r = remove.get(i);
            board[r[0]][r[1]] = wallNum[w++];
        }
    }

    static List<int[]> find() {

        List<int[]> res = new ArrayList<>();

        boolean[][] v = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (v[i][j]) continue;

                List<int[]> list = new ArrayList<>();
                int idx = 0;

                list.add(new int[]{i, j});
                v[i][j] = true;

                while (idx < list.size()) {
                    int[] now = list.get(idx++);

                    for (int q = 0; q < 4; q++) {
                        int x = now[0] + D[q][0];
                        int y = now[1] + D[q][1];

                        if (x < 0 || y < 0 || x > 4 || y > 4 || v[x][y] || board[now[0]][now[1]] != board[x][y]) continue;

                        v[x][y] = true;

                        list.add(new int[]{x, y});
                    }
                }

                if (list.size() > 2) res.addAll(list);
            }
        }

        return res;
    }

    static void rotate(int r, int c) {

        int[][] temp = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = board[r + 1 - j][c - 1 + i];
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[r - 1 + i][c - 1 + j] = temp[i][j];
            }
        }
    }
}
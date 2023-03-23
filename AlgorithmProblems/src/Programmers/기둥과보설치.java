package Programmers;

import java.util.*;

class 기둥과보설치 {
    public int[][] solution(int n, int[][] build_frame) {

        Coordinate[][] wall = new Coordinate[n + 2][];
        for (int i = 0; i <= n + 1; i++) wall[i] = new Coordinate[n + 2];

        for (int i = 0; i <= n + 1; i++) {
            for (int j = 0; j <= n + 1; j++) {
                wall[i][j] = new Coordinate();
            }
        }

        for (int[] order : build_frame) {
            doOrder(order, wall);
        }

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                Coordinate c = wall[i][j];

                if (c.col_bot) list.add(new int[] {i, j, 0});
                if (c.beam_l) list.add(new int[] {i, j, 1});
            }
        }

        int m = list.size();

        int[][] result = new int[m][];
        for (int i = 0; i < m; i++) result[i] = list.get(i);

        return result;
    }

    public void doOrder(int[] order, Coordinate[][] wall) {

        int x = order[0], y = order[1], a = order[2], b = order[3];

        if (a == 0) {
            if (b == 1) {
                if (y == 0 || wall[x][y].col_top || wall[x][y].beam_l || wall[x][y].beam_r) {
                    wall[x][y].col_bot = true;
                    wall[x][y + 1].col_top = true;
                }
            } else {
                if (
                        (wall[x][y + 1].col_bot && !wall[x][y + 1].beam_l && !wall[x][y + 1].beam_r) ||
                                (wall[x][y + 1].beam_l && !wall[x + 1][y].col_bot && !(wall[x][y + 1].beam_r && wall[x + 1][y + 1].beam_l)) ||
                                (wall[x][y + 1].beam_r && !wall[x - 1][y].col_bot && !(wall[x][y + 1].beam_l && wall[x - 1][y + 1].beam_r))
                ) {
                    return;
                }

                wall[x][y].col_bot = false;
                wall[x][y + 1].col_top = false;
            }
        } else {
            if (b == 1) {
                if (wall[x][y].col_top || wall[x + 1][y].col_top || (wall[x][y].beam_r && wall[x + 1][y].beam_l)) {
                    wall[x][y].beam_l = true;
                    wall[x + 1][y].beam_r = true;
                }
            } else {
                if (
                        (wall[x][y].col_bot && !wall[x][y].col_top && !wall[x][y].beam_r) ||
                                (wall[x + 1][y].col_bot && !wall[x + 1][y].col_top && !wall[x + 1][y].beam_l) ||
                                (wall[x][y].beam_r && !wall[x][y].col_top && !wall[x - 1][y].col_top) ||
                                (wall[x + 1][y].beam_l && !wall[x + 1][y].col_top && !wall[x + 2][y].col_top)
                ) {
                    return;
                } else {
                    wall[x][y].beam_l = false;
                    wall[x + 1][y].beam_r = false;
                }
            }
        }
    }

    public class Coordinate {
        boolean col_bot = false;
        boolean col_top = false;
        boolean beam_l = false;
        boolean beam_r = false;
    }
}
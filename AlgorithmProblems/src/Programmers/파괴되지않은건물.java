package Programmers;

class 파괴되지않은건물 {
    public int solution(int[][] board, int[][] skill) {

        int r = board.length, c = board[0].length;
        int[][] acc = new int[r][];
        for (int i = 0; i < r; i++) acc[i] = new int[c];

        for (int[] s : skill) apply(acc, s);

        for (int i = 1; i < r; i++) {
            for (int j = 0; j < c; j++) {
                acc[i][j] += acc[i - 1][j];
            }
        }

        for (int i = 1; i < c; i++) {
            for (int j = 0; j < r; j++) {
                acc[j][i] += acc[j][i - 1];
            }
        }

        int count = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                board[i][j] += acc[i][j];
                if (board[i][j] > 0) count++;
            }
        }


        return count;
    }

    void apply(int[][] acc, int[] skill) {

        int r = acc.length, c = acc[0].length;

        int degree = skill[5];
        if (skill[0] == 1) degree *= -1;

        int r1 = skill[1], c1 = skill[2], r2 = skill[3], c2 = skill[4];

        acc[r1][c1] += degree;
        if (r2 < r - 1) acc[r2 + 1][c1] -= degree;
        if (c2 < c - 1) acc[r1][c2 + 1] -= degree;
        if (r2 < r - 1 && c2 < r - 1) acc[r2 + 1][c2 + 1] += degree;
    }
}
package Programmers;

class 이차원동전뒤집기 {
    public int solution(int[][] beginning, int[][] target) {

        int n = target.length;
        int m = target[0].length;

        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (beginning[i][j] != target[i][j]) board[i][j] = 1;
            }
        }

        int count = 0;

        for (int i = 1; i < n; i++) {
            int s = countSame(board[0], board[i]);

            if (s > 0 && s < m) return -1;

            if (s == 0) count++;
        }

        for (int i = 0; i < m; i++) {
            if (board[0][i] == 1) count++;
        }

        return Math.min(count, n + m - count);
    }

    public int countSame(int[] r1, int[] r2) {

        int count = 0;

        for (int i = 0; i < r1.length; i++) {
            if (r1[i] == r2[i]) count++;
        }

        return count;
    }
}
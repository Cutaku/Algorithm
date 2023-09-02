package Programmers;

class 가장큰정사각형찾기 {
    public int solution(int [][]board) {

        int n = board.length;
        int m = board[0].length;

        int max = 0;

        int[][] b = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                b[i][j] = board[i - 1][j - 1];
            }
        }


        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m; j++) {
                if (b[i][j] == 0) continue;

                b[i][j] = Math.min(b[i - 1][j - 1], Math.min(b[i][j - 1], b[i - 1][j])) + 1;

                max = Math.max(max, b[i][j]);
            }
        }

        return max * max;
    }
}
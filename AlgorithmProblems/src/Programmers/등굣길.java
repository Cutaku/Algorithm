package Programmers;

class 등굣길 {
    public int solution(int m, int n, int[][] puddles) {

        int[][] count = new int[n][];
        boolean[][] pud = new boolean[n][];

        for (int i = 0; i < n; i++) {
            count[i] = new int[m];
            pud[i] = new boolean[m];
        }

        for (int[] puddle : puddles) {
            pud[puddle[1] - 1][puddle[0] - 1] = true;
        }

        count[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pud[i][j]) continue;

                if (i > 0) count[i][j] += count[i - 1][j];
                if (j > 0) count[i][j] += count[i][j - 1];

                count[i][j] %= 1000000007;
            }
        }

        return count[n - 1][m - 1];
    }
}
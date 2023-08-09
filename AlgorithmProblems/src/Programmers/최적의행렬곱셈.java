package Programmers;

class 최적의행렬곱셈 {
    public int solution(int[][] matrix_sizes) {

        int n = matrix_sizes.length;

        int[][] minCount = new int[n][n];

        for (int d = 1; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                minCount[i][i + d] = Integer.MAX_VALUE;

                for (int j = 0; j < d; j++) {
                    minCount[i][i + d] = Math.min(minCount[i][i + d],
                            minCount[i][i + j] + minCount[i + j + 1][i + d]
                                    + matrix_sizes[i][0] * matrix_sizes[i + j][1] * matrix_sizes[i + d][1]);
                }
            }
        }

        return minCount[0][n - 1];
    }
}
package Programmers;

class 사칙연산 {
    public int solution(String[] arr) {

        int n = arr.length / 2 + 1;

        int[][] maxes = new int[n][];
        int[][] mins = new int[n][];

        for (int i = 0; i < n; i++) {
            maxes[i] = new int[n];
            mins[i] = new int[n];
            maxes[i][i] = Integer.parseInt(arr[i * 2]);
            mins[i][i] = Integer.parseInt(arr[i * 2]);
        }

        for (int d = 1; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                int j = i + d;

                int max = -100000;
                int min = 100000;

                for (int k = 0; k < d; k++) {
                    if (arr[(i + k) * 2 + 1].equals("+")) {
                        max = Math.max(max, maxes[i][i + k] + maxes[i + k + 1][j]);
                        min = Math.min(min, mins[i][i + k] + mins[i + k + 1][j]);
                    } else {
                        max = Math.max(max, maxes[i][i + k] - mins[i + k + 1][j]);
                        min = Math.min(min, mins[i][i + k] - maxes[i + k + 1][j]);
                    }
                }

                maxes[i][j] = max;
                mins[i][j] = min;
            }
        }

        return maxes[0][n - 1];
    }
}
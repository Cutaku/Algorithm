package Programmers;

class 카운트다운 {
    public int[] solution(int target) {

        int[][] min = new int[100001][2];
        for (int i = 1; i <= 100000; i++) min[i][0] = 100000;

        for (int i = 1; i <= 20; i++) {
            min[i][0] = 1;
            min[i][1] = 1;

            min[i * 2][0] = 1;
            min[i * 3][0] = 1;
        }

        min[50][0] = 1;
        min[50][1] = 1;

        for (int i = 1; i <= target; i++) {
            if (min[i][0] < 100000) continue;

            for (int j = 1; j <= i / 2; j++) {
                if (min[j][0] + min[i - j][0] < min[i][0]) {
                    min[i][0] = min[j][0] + min[i - j][0];
                    min[i][1] = min[j][1] + min[i - j][1];
                } else if (min[j][0] + min[i - j][0] == min[i][0]) {
                    min[i][1] = Math.max(min[i][1], min[j][1] + min[i - j][1]);
                }
            }
        }

        return min[target];
    }
}
package Programmers;

class 땅따먹기 {
    public int solution(int[][] land) {

        int n = land.length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                land[i][j] += findMax(land[i - 1], j);
            }
        }

        return findMax(land[n - 1], n);
    }

    int findMax(int[] arr, int except) {

        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i == except) continue;

            if (arr[i] > max) max = arr[i];
        }

        return max;
    }
}
package Programmers;

class 정수삼각형 {
    public int solution(int[][] triangle) {

        int l = triangle.length;

        int[][] sum = new int[l][];
        for (int i = 0; i < l ;i++) sum[i] = new int[i + 3];

        sum[0][1] = triangle[0][0];

        for (int i = 1; i < l; i++) {
            for (int j = 1; j < i + 2; j++) {
                sum[i][j] = Math.max(sum[i - 1][j - 1], sum[i - 1][j]) + triangle[i][j - 1];
            }
        }

        int max = 0;
        for (int num : sum[l - 1]) max = Math.max(max, num);

        return max;
    }
}
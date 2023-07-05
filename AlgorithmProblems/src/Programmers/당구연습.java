package Programmers;

class 당구연습 {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {

        int l = balls.length;

        int[] result = new int[l];

        for (int i = 0; i < l; i++) {
            result[i] = findMin(m, n, startX, startY, balls[i][0], balls[i][1]);
        }

        return result;
    }

    public int findMin(int m, int n, int x, int y, int X, int Y) {

        int[][] reflects = new int[][]{{-1 * X, Y}, {X, -1 * Y}, {X, 2 * n - Y}, {2 * m - X, Y}};

        int min = 4000000;

        for (int[] reflect : reflects) {
            if (x == reflect[0]) {
                if (Y < y && reflect[1] < 0) continue;
                if (y < Y && reflect[1] > 0) continue;
            }

            if (y == reflect[1]) {
                if (X < x && reflect[0] < 0) continue;
                if (x < X && reflect[0] > 0) continue;
            }

            min = Math.min(min, (x - reflect[0]) * (x - reflect[0]) + (y - reflect[1]) * (y - reflect[1]));
        }

        return min;
    }
}
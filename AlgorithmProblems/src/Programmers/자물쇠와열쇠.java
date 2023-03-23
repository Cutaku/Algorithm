package Programmers;
class 자물쇠와열쇠 {
    public boolean solution(int[][] key, int[][] lock) {

        int n = lock.length;
        int m = lock.length;

        for (int r = 0; r < 4; r++) {
            for (int i = 0; i < n + m - 1; i++) {
                for (int j = 0; j < n + m - 1; j++) {
                    if (fit (lock, key, i, j)) return true;
                }
            }

            key = rotate(key);
        }

        return false;
    }

    public int[][] rotate(int[][] key) {

        int m = key.length;

        int[][] result = new int[m][];
        for (int i = 0; i < m; i++) result[i] = new int[m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = key[m - j - 1][i];
            }
        }

        return result;
    }

    public boolean fit(int[][] lock, int[][] key, int x, int y) {

        int n = lock.length;
        int m = key.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int ni = m - 1 - x + i;
                int nj = m - 1 - y + j;

                if (ni >= 0 && nj >= 0 && ni < m && nj < m) {
                    if (lock[i][j] + key[ni][nj] != 1) return false;
                } else {
                    if (lock[i][j] != 1) return false;
                }
            }
        }

        return true;
    }
}
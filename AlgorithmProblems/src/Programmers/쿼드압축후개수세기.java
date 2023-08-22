package Programmers;

class 쿼드압축후개수세기 {
    int zero;
    int one;

    public int[] solution(int[][] arr) {

        zero = 0;
        one = 0;

        int n = arr.length;

        compress(arr, 0, 0, n);

        return new int[]{zero, one};
    }

    public void compress(int[][] arr, int x, int y, int l) {

        boolean isAllSame = true;

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (arr[x + i][y + j] != arr[x][y]) {
                    isAllSame = false;
                    break;
                }
            }
        }

        if (isAllSame) {
            if (arr[x][y] == 1) one++;
            else zero++;
        } else {
            int r = l / 2;

            compress(arr, x, y, r);
            compress(arr, x  + r, y, r);
            compress(arr, x, y + r, r);
            compress(arr, x + r, y + r, r);
        }
    }
}
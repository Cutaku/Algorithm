package Programmers;

class 하노이의탑 {
    public int[][] solution(int n) {

        int[][] ans = new int[][]{{1, 3}};

        for (int i = 1; i < n; i++) {
            int l = ans.length;

            int[][] temp = new int[2 * l + 1][];

            for (int j = 0; j < l; j++) temp[j] = change(ans[j], 2, 3);

            temp[l] = new int[]{1, 3};

            for (int j = 0; j < l; j++) temp[l + j + 1] = change(ans[j], 1, 2);

            ans = temp;
        }

        return ans;
    }

    public int[] change(int[] t, int a, int b) {

        int l = t.length;

        int[] result = new int[l];

        for (int i = 0; i < l; i++) {
            if (t[i] == a) result[i] = b;
            else if (t[i] == b) result[i] = a;
            else result[i] = t[i];
        }

        return result;
    }
}
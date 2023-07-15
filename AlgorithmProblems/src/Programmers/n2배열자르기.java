package Programmers;

class n2배열자르기 {
    public int[] solution(int n, long left, long right) {

        int[] ans = new int[(int) (right - left + 1)];

        int j = 0;

        for (long i = left; i <= right; i++) {
            int x = (int) (i / n);
            int y = (int) (i % n);

            ans[j++] = Math.max(x, y) + 1;
        }

        return ans;
    }
}
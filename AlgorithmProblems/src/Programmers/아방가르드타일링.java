package Programmers;

class 아방가르드타일링 {
    public int solution(int n) {

        int[] ans = new int[Integer.max(4, n + 1)];

        ans[0] = 1;
        ans[1] = 1;
        ans[2] = 3;

        for (int i = 3; i <= n; i++) {
            long t = 0;

            t += ans[i - 1];
            t += (long) ans[i - 2] * 2;
            t += (long) ans[i - 3] * 5;

            for (int j = 4; j <= i; j += 3) {
                t += (long) ans[i - j] * 2;
            }

            for (int j = 5; j <= i; j += 3) {
                t += (long) ans[i - j] * 2;
            }

            for (int j = 6; j <= i; j += 3) {
                t += (long) ans[i - j] * 4;
            }

            ans[i] = (int)(t % 1000000007);
        }

        return ans[n];
    }
}
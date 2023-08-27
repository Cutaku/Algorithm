package Programmers;

class 멀리뛰기 {
    public long solution(int n) {

        long[] ans = new long[n + 1];

        ans[0] = 1;
        ans[1] = 1;

        for (int i = 2; i <= n; i++) {
            ans[i] = ans[i - 1] + ans[i - 2];
            ans[i] %= 1234567;
        }

        return ans[n];
    }
}
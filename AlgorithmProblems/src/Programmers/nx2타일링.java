package Programmers;

class nx2타일링 {
    public int solution(int n) {

        int d = 1000000007;

        int[] ans = new int[n + 1];
        ans[0] = 1;
        ans[1] = 1;

        for (int i = 2; i <= n; i++) {
            ans[i] += ans[i - 1] + ans[i - 2];
            ans[i] %= d;
        }

        return ans[n];
    }
}
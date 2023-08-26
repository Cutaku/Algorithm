package Programmers;

class nx3타일링 {
    public int solution(int n) {

        int d = 1000000007;

        long[] ans = new long[n + 1];
        ans[0] = 1;

        for (int i = 2; i <= n; i += 2) {
            ans[i] += 3 * ans[i - 2];
            ans[i] %= d;

            for (int j = 0; j < i - 2; j += 2) {
                ans[i] += 2 * ans[j];
                ans[i] %= d;
            }
        }

        return (int) ans[n];
    }
}
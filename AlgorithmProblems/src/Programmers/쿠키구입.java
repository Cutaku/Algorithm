package Programmers;

class 쿠키구입 {
    public int solution(int[] cookie) {

        int n = cookie.length;

        int[] c = new int[n + 1];

        for (int i = 1; i <= n; i++) c[i] = c[i - 1] + cookie[i - 1];

        int max = 0;

        for (int l = 0; l < n - 1; l++) {
            int m = l + 1;
            int r = m + 1;

            while (r <= n) {
                if (m == r) {
                    r++;
                    continue;
                }

                int s1 = c[m] - c[l];
                int s2 = c[r] - c[m];

                if (s1 > s2) {
                    r++;
                } else if (s1 < s2) {
                    m++;
                } else {
                    max = Math.max(max, s1);
                    r++;
                }
            }
        }

        return max;
    }
}
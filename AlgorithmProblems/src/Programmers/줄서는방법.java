package Programmers;

class 줄서는방법 {
    public int[] solution(int n, long k) {

        int[] ans = new int[n];
        boolean[] used = new boolean[n + 1];

        for (int i = 0; i < n; i++) {

            int m = 1;
            while (used[m]) m++;

            long d = 1;
            for (int j = 1; j < n - i; j++) d *= j;

            while (m < n && k > d) {
                k -= d;
                m++;
                while (used[m]) m++;
            }

            ans[i] = m;
            used[m] = true;
        }

        return ans;
    }
}
package Programmers;

class 선입선출스케줄링 {
    public int solution(int n, int[] cores) {

        int l = cores.length;

        if (n <= l) return n;

        int s = 0;
        int e = 250000000;

        while (e - s > 1) {
            int m = (s + e) / 2;

            long count = l;

            for (int core : cores) {
                count += m / core;
            }

            if (count < n) s = m;
            else e = m;
        }

        int count = l;

        for (int core : cores) {
            count += s / core;
        }

        int ans = 0;

        for (int i = 0; i < l; i++) {
            if (e % cores[i] == 0) {
                count++;
                ans = i + 1;
            }

            if (count == n) break;
        }

        return ans;
    }
}
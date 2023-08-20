package Programmers;

class 숫자블록 {
    public int[] solution(long begin, long end) {

        int d = (int) (end - begin + 1);

        int[] ans = new int[d];

        for (int i = 0; i < d; i++) {
            ans[i] = findAns(begin + i);
        }

        return ans;
    }

    public int findAns(long n) {

        if (n == 1) return 0;

        int d = 1;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                d = i;

                if (n / i <= 10000000) {
                    return (int) (n / i);
                }
            }
        }

        return d;
    }
}
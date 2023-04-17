package Programmers;

class 입국심사 {
    public long solution(int n, int[] times) {

        long s = 0l;
        long e = 1000000000000000000l;

        while (e - s > 1) {
            long m = (e + s) / 2;

            long c = 0;
            for (int time : times) c += m / time;

            if (c >= n) e = m;
            else s = m;
        }

        return e;
    }
}
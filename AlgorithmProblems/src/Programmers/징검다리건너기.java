package Programmers;

class 징검다리건너기 {
    public int solution(int[] stones, int k) {

        int s = 1;
        int e = 2000000000;

        while (e - s > 1) {

            int m = (e + s) / 2;

            if (check(stones, k, m)) s = m;
            else e = m;
        }

        return s;
    }

    boolean check(int[] stones, int k, int m) {

        int max = 0;
        int conti = 0;

        for (int stone : stones) {
            if (stone < m) {
                conti++;
                max = Math.max(max, conti);

                if (max >= k) return false;
            } else {
                conti = 0;
            }
        }

        return true;
    }
}
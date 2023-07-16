package Programmers;

class 점찍기 {
    public long solution(int k, int d) {

        long ans = 0;

        for (long i = 0; i <= d; i += k) {
            ans += (int) (Math.sqrt((long) d * (long) d - i * i) / k + 1);
        }

        return ans;
    }
}
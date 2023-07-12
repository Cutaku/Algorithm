package Programmers;

class 두원사이의정수쌍 {
    public long solution(int r1, int r2) {

        long count = 0;

        for (long i = 0; i < r2; i++) {
            count += (long) Math.sqrt((long) r2 * (long) r2 - i * i);
            if (r1 > i) count -= (long) Math.ceil(Math.sqrt((long) r1 * (long) r1 - i * i)) - 1;
        }

        return 4 * count;
    }
}
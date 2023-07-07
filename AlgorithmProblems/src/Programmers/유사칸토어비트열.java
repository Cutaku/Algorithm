package Programmers;

class 유사칸토어비트열 {
    public int solution(int n, long l, long r) {

        int count = 0;

        for (long i = l; i <= r; i++) {
            count += cantor(i);
        }

        return count;
    }

    public int cantor(long n) {

        if (n % 5 == 3) return 0;

        if (n < 5) return 1;

        return cantor((n + 4) / 5);
    }
}
package Programmers;

class 연속펄스부분수열의합 {
    public long solution(int[] sequence) {

        int n = sequence.length;

        int[] pulse = new int[n];

        pulse[0] = 1;

        for (int i = 0; i < n; i++) {
            pulse[i] = (int) Math.pow(-1, i) * sequence[i];
        }

        long max1 = -100000;
        long max2 = max1;

        long sum1 = 0;
        long sum2 = 0;

        for (int i = 0; i < n; i++) {
            sum1 += pulse[i];
            sum2 -= pulse[i];

            max1 = Math.max(max1, sum1);
            max2 = Math.max(max2, sum2);

            if (sum1 < 0) sum1 = 0;
            if (sum2 < 0) sum2 = 0;
        }

        return Math.max(max1, max2);
    }
}
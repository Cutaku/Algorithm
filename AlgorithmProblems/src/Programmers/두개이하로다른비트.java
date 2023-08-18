package Programmers;

class 두개이하로다른비트 {
    public long[] solution(long[] numbers) {

        int n = numbers.length;

        long[] ans = new long[n];

        for (int i = 0; i < n; i++) {
            int[] bin = toBinary(numbers[i]);

            int j = 0;

            while (bin[j] == 1) j++;

            bin[j] = 1;
            if (j > 0) bin[j - 1] = 0;

            ans[i] = toLong(bin);
        }

        return ans;
    }

    public int[] toBinary(long n) {

        int[] result = new int[50];

        int i = 0;

        while (n > 0) {
            result[i++] = (int) (n % 2);
            n /= 2;
        }

        return result;
    }

    public long toLong(int[] bin) {

        long result = 0;

        long p = 1;

        for (int i = 0; i < 50; i++) {
            result += bin[i] * p;
            p *= 2;
        }

        return result;
    }
}
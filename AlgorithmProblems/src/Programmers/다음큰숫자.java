package Programmers;

class 다음큰숫자 {
    public int solution(int n) {

        int[] bin = toBinary(n);

        int i = 0;
        int count = 0;

        while (bin[i] == 0 || bin[i + 1] == 1) {
            count += bin[i];
            bin[i++] = 0;
        }

        bin[i] = 0;
        bin[i + 1] = 1;


        for (int j = 0; j < count; j++) bin[j] = 1;

        return toInt(bin);
    }

    public int[] toBinary(int n) {

        int[] result = new int[22];

        for (int i = 0; i < 22; i++) {
            result[i] = n % 2;
            n /= 2;
        }

        return result;
    }

    public int toInt(int[] bin) {

        int result = 0;

        int n = 1;

        for (int i = 0; i < 22; i++) {
            result += n * bin[i];
            n *= 2;
        }

        return result;
    }
}
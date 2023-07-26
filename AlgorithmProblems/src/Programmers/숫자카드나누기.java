package Programmers;

class 숫자카드나누기 {
    public int solution(int[] arrayA, int[] arrayB) {

        int gcd_A = findGCD(arrayA);
        int gcd_B = findGCD(arrayB);

        for (int num : arrayA) {
            if (num % gcd_B == 0) {
                gcd_B = 0;
                break;
            }
        }

        for (int num : arrayB) {
            if (num % gcd_A == 0) {
                gcd_A = 0;
                break;
            }
        }

        return Math.max(gcd_A, gcd_B);
    }

    public int findGCD(int[] array) {

        int gcd = array[0];

        for (int i = 1; i < array.length; i++) {
            gcd = findGCD(gcd, array[i]);
        }

        return gcd;
    }

    public int findGCD(int a, int b) {

        while (b > 0) {
            int t = b;
            b = a % b;
            a = t;
        }

        return a;
    }
}
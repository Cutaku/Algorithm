package Programmers;

class N개의최소공배수 {
    public int solution(int[] arr) {

        int lcm = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int gcd = findGCD(lcm, arr[i]);

            lcm *= arr[i] / gcd;
        }

        return lcm;
    }

    public int findGCD(int a, int b) {

        while (a % b > 0) {
            int c = b;
            b = a % b;
            a = c;
        }

        return b;
    }
}
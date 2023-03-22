package Programmers;

import java.util.*;

class k진수에서소수개수구하기 {
    public int solution(int n, int k) {

        String n_k = change(n, k);

        long[] nums = Arrays.stream(n_k.replaceAll("0", " ").split("\\s+")).mapToLong(Long::parseLong).toArray();

        int count = 0;
        for (long num : nums) {
            if (isPrime(num)) count++;
        }

        return count;
    }

    String change(int n, int base) {
        String result = "";

        do {
            result = (n % base) + result;
            n /= base;
        } while (n > 0);

        return result;
    }

    boolean isPrime(long n) {

        if (n == 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i < Math.sqrt(n) + 1; i += 2) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
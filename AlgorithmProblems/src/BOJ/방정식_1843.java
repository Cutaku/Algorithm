package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 방정식_1843 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> div = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) div.add(i);
        }

        int s = div.size();
        if (div.get(s - 1) * div.get(s - 1) == n) s = s * 2 - 1;
        else s = 2 * s;

        int[] dividers = new int[s];
        for (int i = 0; i < (s + 1) / 2; i++) {
            dividers[i] = div.get(i);
            dividers[s - 1 - i] = n / div.get(i);
        }

        List<Integer> primes = new ArrayList<>();
        boolean[] isNotPrime = new boolean[n + 1];
        isNotPrime[1] = true;

        for (int i = 3; i <= n; i += 2) {
            if (!isNotPrime[i]) primes.add(i);

            for (int j = 3; i * j <= n; j += 2) {
                isNotPrime[i * j] = true;
            }
        }

        int b = 0;

        for (int i = 0; i < s; i++) {
            for (int j = i; j < s; j++) {
                if (hasValue(dividers, dividers[i] + dividers[j])) {
                    b++;
                }
            }
        }

        int c = 0;

        for (int prime : primes) {
            if (!isNotPrime[prime - 2]) c++;
        }

        System.out.println(n % 2 == 1 ? (long) (n / 2) * (n / 2) : (long) (n / 2) * (n / 2 - 1));
        System.out.println(b);
        System.out.println(c);
    }

    static boolean hasValue(int[] arr, int v) {

        int s = 0, e = arr.length - 1;

        if (arr[s] > v) return false;
        else if (arr[s] == v) return true;

        while (e - s > 1) {
            int m = (s + e) / 2;

            if (arr[m] < v) s = m;
            else e = m;
        }

        return arr[e] == v;
    }
}
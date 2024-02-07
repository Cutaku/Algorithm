package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 시로코와은행털기_26670 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nkx = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nkx[0], k = nkx[1], x = nkx[2];

        Set<Integer>[] sets = new Set[k];
        for (int i = 0; i < k; i++) sets[i] = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int[] ability = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int d = ability[1] - ability[0];

            for (int j = k - 2; j >= 0; j--) {
                for (int num : sets[j]) {
                    sets[j + 1].add(num + d);
                }
            }

            sets[0].add(d);
        }

        int min = Integer.MAX_VALUE;

        for (int num : sets[k - 1]) {
            min = Math.min(min, Math.abs(num));
        }

        int a = (x * k - min) / 2;

        System.out.println(a * (a + min));
    }
}
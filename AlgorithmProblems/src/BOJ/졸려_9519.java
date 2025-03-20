package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 졸려_9519 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        char[] word = br.readLine().toCharArray();
        int l = word.length;

        int[] permutation = new int[l];

        for (int i = 0; i < (l + 1) / 2; i++) {
            permutation[2 * i] = i;
        }

        for (int i = 0; i < l / 2; i++) {
            permutation[2 * i + 1] = l - i - 1;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < l; i++) {
            int cycle = 1;

            int idx = i;
            while (permutation[idx] != i) {
                idx = permutation[idx];
                cycle++;
            }

            int r = x % cycle;
            r = (cycle - r) % cycle;
            idx = i;

            for (int j = 0; j < r; j++) idx = permutation[idx];

            sb.append(word[idx]);
        }

        System.out.println(sb);
    }
}
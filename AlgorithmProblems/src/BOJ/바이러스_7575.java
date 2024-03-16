package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 바이러스_7575 {
    static int k;
    static int[][] programs;
    static int[][] reverses;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        programs = new int[n][];
        reverses = new int[n][];

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());

            programs[i] = new int[m];

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                programs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(programs, Comparator.comparingInt(p -> p.length));

        for (int i = 0; i < n; i++) {
            reverses[i] = reverse(programs[i]);
        }

        if (hasVires()) System.out.println("YES");
        else System.out.println("NO");
    }

    static boolean hasVires() {

        for (int i = 0; i < programs[0].length - k + 1; i++) {
            int[] subCode = Arrays.copyOfRange(programs[0], i, i + k);
            int[] pi = makePi(subCode);

            if (canBeVirus(subCode, pi)) return true;
        }

        return false;
    }

    static boolean canBeVirus(int[] subCode, int[] pi) {

        for (int p = 1; p < programs.length; p++) {
            if (!contains(p, subCode, pi)) return false;
        }

        return true;
    }

    static boolean contains(int p, int[] subCode, int[] pi) {

        if (con(programs[p], subCode, pi)) return true;

        return con(reverses[p], subCode, pi);
    }

    static int[] reverse(int[] arr) {

        int[] res = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[arr.length - 1 - i];
        }

        return res;
    }

    static boolean con(int[] program, int[] subCode, int[] pi) {

        int same = 0;
        int idx = 0;

        while (idx + same < program.length) {
            if (program[idx + same] == subCode[same]) {
                same++;

                if (same == subCode.length) return true;
            } else if (same == 0) {
                idx++;
            } else {
                idx += same - pi[same - 1];
                same = pi[same - 1];
            }
        }

        return false;
    }

    static int[] makePi(int[] subCode) {

        int l = subCode.length;

        int[] pi = new int[l];

        for (int i = 1; i < l; i++) {
            int p = pi[i - 1];

            while (p > 0 && subCode[p] != subCode[i]) p = pi[p - 1];

            if (subCode[p] == subCode[i]) p++;
            pi[i] = p;
        }

        return pi;
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KingsTask_21995 {
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int[] a = new int[2 * n];
        int[] b = new int[2 * n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 2 * n; i++) {
            a[i] = b[i] = Integer.parseInt(st.nextToken());
        }

        int p = n % 2 == 0 ? 4 : 2 * n;

        for (int i = 0; i < p; i++) {
            if (check(a) || check(b)) {
                System.out.println(i);
                return;
            }

            if (i % 2 == 0) {
                o1(a);
                o2(b);
            } else {
                o2(a);
                o1(b);
            }
        }

        System.out.println(-1);
    }

    static void o1(int[] a) {

        for (int i = 0; i < n; i++) {
            int t = a[2 * i];
            a[2 * i] = a[2 * i + 1];
            a[2 * i + 1] = t;
        }
    }

    static void o2(int[] a) {

        for (int i = 0; i < n; i++) {
            int t = a[i];
            a[i] = a[n + i];
            a[n + i] = t;
        }
    }

    static boolean check(int[] a) {

        for (int i = 0; i < 2 * n; i++) {
            if (a[i] != i + 1) return false;
        }

        return true;
    }
}
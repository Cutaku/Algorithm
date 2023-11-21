package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 전구와스위치_2138 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String b1 = br.readLine();
        String b2 = br.readLine();

        boolean[] a1 = new boolean[n];
        boolean[] a2 = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (b1.charAt(i) == b2.charAt(i)) {
                a1[i] = true;
                a2[i] = true;
            }
        }

        int c1 = 1;
        int c2 = 0;

        a1[0] = !a1[0];
        a1[1] = !a1[1];

        for (int i = 0; i < n - 1; i++) {
            if (!a1[i]) {
                a1[i] = !a1[i];
                a1[i + 1] = !a1[i + 1];
                if (i < n - 2) a1[i + 2] = !a1[i + 2];
                c1++;
            }

            if (!a2[i]) {
                a2[i] = !a2[i];
                a2[i + 1] = !a2[i + 1];
                if (i < n - 2) a2[i + 2] = !a2[i + 2];
                c2++;
            }
        }

        if (a1[n - 1] && a2[n - 1]) {
            System.out.println(Math.min(c1, c2));
        } else if (a1[n - 1]) {
            System.out.println(c1);
        } else if (a2[n - 1]) {
            System.out.println(c2);
        } else {
            System.out.println(-1);
        }
    }
}
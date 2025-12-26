package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A를B로_13019 {
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();
        int l = A.length();

        if (!check(A, B)) {
            System.out.println(-1);
            return;
        }

        int i = l - 1;
        int j = l - 1;

        while (i >= 0) {
            if (A.charAt(i) == B.charAt(j)) j--;
            i--;
        }

        System.out.println(j + 1);
    }

    static boolean check(String A, String B) {

        int[] cnt = new int[26];

        for (int i = 0; i < A.length(); i++) {
            cnt[A.charAt(i) - 'A']++;
            cnt[B.charAt(i) - 'A']--;
        }

        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) return false;
        }

        return true;
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 문자열추측_16925 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] fix = new String[2 * n - 2];
        String[] longest = new String[2];

        for (int i = 0; i < 2 * n - 2; i++) {
            fix[i] = br.readLine();

            if (fix[i].length() == n - 1) {
                if (longest[0] == null) longest[0] = fix[i];
                else longest[1] = fix[i];
            }
        }

        String prefix, suffix;

        if (check(longest[0], longest[1])) {
            prefix = longest[0];
            suffix = longest[1];
        } else {
            prefix = longest[1];
            suffix = longest[0];
        }

        System.out.println(ans(prefix, suffix, fix));
    }

    static boolean check(String prefix, String suffix) {

        for (int i = 0; i < prefix.length() - 1; i++) {
            if (prefix.charAt(i + 1) != suffix.charAt(i)) return false;
        }

        return true;
    }

    static String ans(String prefix, String suffix, String[] fix) {

        int n = prefix.length() + 1;

        Set<String> prefixSet = new HashSet<>();

        for (int i = 1; i < n; i++) {
            prefixSet.add(prefix.substring(0, i));
        }

        StringBuilder sb = new StringBuilder();
        sb.append(prefix.charAt(0)).append(suffix).append("\n");

        int s = 0, p = 0;

        for (int i = 0; i < 2 * n - 2; i++) {
            if (prefixSet.contains(fix[i])) {
                sb.append("P");
                prefixSet.remove(fix[i]);
                p++;
            } else {
                sb.append("S");
                s++;
            }
        }

        if (s == p) return sb.toString();
        else return ans(suffix, prefix, fix);
    }
}
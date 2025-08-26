package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Contact_1013 {
    static String input;
    static int l;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            input = br.readLine();
            l = input.length();

            sb.append(dfs(0) ? "YES\n" : "NO\n");
        }

        System.out.println(sb);
    }

    static boolean dfs(int i) {

        if (i == l) return true;

        if (input.charAt(i) == '0') {
            if (i == l - 1 || input.charAt(i + 1) == '0') return false;

            return dfs(i + 2);
        } else {
            int j = i + 1;
            while (j < l && input.charAt(j) == '0') j++;

            if (j == l || j - i < 3) return false;

            boolean res = false;

            do {
                res |= dfs(j++ + 1);
            } while (j < l && input.charAt(j) == '1');

            return res;
        }
    }
}
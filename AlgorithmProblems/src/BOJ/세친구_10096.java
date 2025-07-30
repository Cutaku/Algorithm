package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 세친구_10096 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String u = br.readLine();

        if (n % 2 == 0) {
            System.out.println("NOT POSSIBLE");
            return;
        }

        Set<String> set = new HashSet<>();

        int l = 0, r = n / 2;
        boolean jump = false;

        while (l < n / 2) {
            if (u.charAt(l) == u.charAt(r)) {
                l++;
                r++;
            } else {
                if (!jump) {
                    r++;
                    jump = true;
                } else {
                    break;
                }
            }
        }

        if (l == n / 2) set.add(u.substring(0, n / 2));

        l = 0;
        r = n / 2 + 1;
        jump = false;

        while (r < n) {
            if (u.charAt(l) == u.charAt(r)) {
                l++;
                r++;
            } else {
                if (!jump) {
                    l++;
                    jump = true;
                } else {
                    break;
                }
            }
        }

        if (r == n) set.add(u.substring(n / 2 + 1));

        if (set.isEmpty()) {
            System.out.println("NOT POSSIBLE");
        } else if (set.size() == 1) {
            System.out.println(set.iterator().next());
        } else {
            System.out.println("NOT UNIQUE");
        }
    }
}
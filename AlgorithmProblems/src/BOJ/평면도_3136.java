package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 평면도_3136 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String dir = br.readLine();

        int[] d = new int[n];
        for (int i = 0; i < n; i++) d[i] = dir.charAt(i) - '0';

        int[][] D = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

        Set<String> vSet = new HashSet<>();
        Set<String> eSet = new HashSet<>();

        int x = 0, y = 0;
        String v = "0 0";

        vSet.add(v);

        int count = 0;

        for (int i = 0; i < 2 * n; i++) {
            x += D[d[i / 2]][0];
            y += D[d[i / 2]][1];

            String nv = vToString(x, y);

            String e = eToString(v, nv);

            if (!vSet.add(nv) & eSet.add(e)) count++;

            v = nv;
        }

        System.out.println(count);
    }

    static String vToString(int x, int y) {

        return String.valueOf(x) + ' ' + y;
    }

    static String eToString(String v1, String v2) {

        StringBuilder sb = new StringBuilder();

        if (v1.compareTo(v2) > 0) {
            String temp = v1;
            v1 = v2;
            v2 = temp;
        }

        sb.append(v1).append(' ').append(v2);

        return sb.toString();
    }
}
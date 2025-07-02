package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 대회개최_12915 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());
        int em = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int mh = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int l = 0;
        int r = (e + em + m + mh + h) / 3 + 1;

        while (r - l > 1) {
            int c = (l + r) >> 1;

            if (check(c, e, em, m, mh, h)) l = c;
            else r = c;
        }

        System.out.println(l);
    }

    static boolean check(int c, int e, int em, int m, int mh, int h) {

        if (c > e + em) return false;
        em -= Math.max(0, c - e);

        if (c > h + mh) return false;
        mh -= Math.max(0, c - h);

        return c <= em + m + mh;
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 셔틀버스_14701 {
    static int n, m;
    static int[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tree = new int[n + 1];

        int l = n / 2, r = l + 1;
        boolean odd = n % 2 == 1;
        boolean left = false;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int q = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            if (q == 1) {
                if (odd && r == l + 1) {
                    r++;
                    if (x <= n / 2) left = true;
                } else if (x <= n / 2) {
                    l--;
                } else if (x > (n + 1) / 2){
                    r++;
                } else {
                    if (left) l--;
                    else r++;
                }

                remove(x);
            } else {
                if (x <= l) sb.append(find(x)).append("\n");
                else if (x >= r) sb.append(find(x - r + 1 + l)).append("\n");
                else sb.append("0\n");
            }
        }

        System.out.println(sb);
    }

    static void remove(int i) {

        while (i <= n) {
            tree[i]++;
            i += i & -i;
        }
    }

    static int sum(int i) {

        int res = 0;

        while (i > 0) {
            res += tree[i];
            i -= i & -i;
        }

        return res;
    }

    static int find(int i) {

        int s = 0, e = n;

        while (e - s > 1) {
            int m = (s + e) >> 1;

            if (m - sum(m) < i) s = m;
            else e = m;
        }

        return e;
    }
}
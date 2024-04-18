package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퍼레이드_16168 {
    static int[] roots;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());

        roots = new int[v];
        for (int i = 1; i < v; i++) roots[i] = i;

        int[] count = new int[v];

        int union = 1;

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;

            count[v1]++;
            count[v2]++;

            int r1 = find(v1);
            int r2 = find(v2);

            if (r1 != r2) {
                union++;

                roots[Math.max(r1, r2)] = Math.min(r1, r2);
            }
        }

        if (union != v) {
            System.out.println("NO");
            return;
        }

        int odd = 0;

        for (int i = 0; i < v; i++) {
            if (count[i] % 2 == 1) odd++;
        }

        if (odd == 0 || odd == 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static int find(int a) {

        if (roots[a] == a) return a;
        else return roots[a] = find(roots[a]);
    }
}

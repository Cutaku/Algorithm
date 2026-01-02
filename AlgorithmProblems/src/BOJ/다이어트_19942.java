package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다이어트_19942 {
    static int n;
    static int mp, mf, ms, mv;
    static Ingredient[] ingredients;
    static int min;
    static int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());

        ingredients = new Ingredient[n];
        for (int i = 0; i < n; i++) ingredients[i] = new Ingredient(br.readLine());

        min = Integer.MAX_VALUE;
        ans = 0;

        dfs(0, 0, 0, 0, 0, 0, 0);

        if (ans == 0) {
            System.out.println(-1);
            return;
        }


        StringBuilder sb = new StringBuilder();
        sb.append(min).append("\n");

        for (int i = 0; i < n; i++) {
            if (ans % 2 == 1) {
                sb.append(i + 1).append(" ");
            }

            ans /= 2;
        }

        System.out.println(sb);
    }

    static void dfs(int d, int sp, int sf, int ss, int sv, int sc, int use) {

        if (sc >= min) return;

        if (sp >= mp && sf >= mf && ss >= ms && sv >= mv) {
            min = sc;
            ans = use;
            return;
        }

        if (d == n) return;

        Ingredient i = ingredients[d];

        dfs(d + 1, sp + i.p, sf + i.f, ss + i.s, sv + i.v, sc + i.c, use + (1 << d));
        dfs(d + 1, sp, sf, ss, sv, sc, use);
    }

    static class Ingredient {

        int p, f, s, v, c;

        public Ingredient(String input) {
            StringTokenizer st = new StringTokenizer(input);
            p = Integer.parseInt(st.nextToken());
            f = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }
    }
}
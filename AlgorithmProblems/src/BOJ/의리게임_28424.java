package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 의리게임_28424 {
    static int n;
    static int[] max, drink, root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        max = new int[n];
        root = new int[n + 1];
        drink = new int[n];

        for (int i = 0; i < n; i++) {
            max[i] = Integer.parseInt(br.readLine());
            root[i] = i;
        }

        root[n] = n;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int o = Integer.parseInt(st.nextToken());

            if (o == 1) {
                int idx = next(Integer.parseInt(st.nextToken()) - 1);
                int x = Integer.parseInt(st.nextToken());

                while (x > 0 && idx < n) {
                    int d = Math.min(max[idx] - drink[idx], x);

                    drink[idx] += d;
                    x -= d;

                    if (max[idx] == drink[idx]) root[idx] = next(idx + 1);

                    idx = next(idx);
                }
            } else {
                sb.append(drink[Integer.parseInt(st.nextToken()) - 1]).append("\n");
            }
        }

        System.out.println(sb);
    }

    static int next(int a) {

        if (a == root[a]) return a;
        return root[a] = next(root[a]);
    }
}
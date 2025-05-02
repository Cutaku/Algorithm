package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나도리합_28251 {
    static int[] root;
    static long[] sum;
    static long[] power;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken());

        root = new int[n + 1];
        sum = new long[n + 1];
        power = new long[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            root[i] = i;
            sum[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int a = find(Integer.parseInt(st.nextToken()));
            int b = find(Integer.parseInt(st.nextToken()));

            if (a == b) {
                sb.append(power[a]).append("\n");
            } else {
                int l = Math.min(a, b), r = Math.max(a, b);

                root[r] = l;
                power[l] += power[r] + sum[l] * sum[r];
                sum[l] += sum[r];

                sb.append(power[l]).append("\n");
            }
        }

        System.out.println(sb);
    }

    static int find(int a) {

        if (a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}
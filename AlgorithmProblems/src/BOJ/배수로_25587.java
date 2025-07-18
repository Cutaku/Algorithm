package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 배수로_25587 {
    static int n;
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        root = new int[n];
        for (int i = 1; i < n; i++) root[i] = i;

        int[] cap = new int[n];
        int[] rain = new int[n];
        int[] size = new int[n];
        int cnt = 0;

        Arrays.fill(size, 1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) cap[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            rain[i] = Integer.parseInt(st.nextToken());

            if (rain[i] > cap[i]) cnt++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int q = Integer.parseInt(st.nextToken());

            if (q == 2) {
                sb.append(cnt).append("\n");
            } else {
                int a = find(Integer.parseInt(st.nextToken()) - 1);
                int b = find(Integer.parseInt(st.nextToken()) - 1);

                if (a == b) continue;

                if (rain[a] > cap[a]) cnt -= size[a];
                if (rain[b] > cap[b]) cnt -= size[b];

                if (a > b) {
                    int t = a;
                    a = b;
                    b = t;
                }

                cap[a] += cap[b];
                rain[a] += rain[b];
                size[a] += size[b];
                root[b] = a;

                if (rain[a] > cap[a]) cnt += size[a];
            }
        }

        System.out.println(sb);
    }

    static int find(int a) {

        if (root[a] == a) return a;
        return root[a] = find(root[a]);
    }
}
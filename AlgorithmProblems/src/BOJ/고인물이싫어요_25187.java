package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 고인물이싫어요_25187 {
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken());

        root = new int[n];
        for (int i = 1; i < n; i++) root[i] = i;

        int[] count = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) count[i] = st.nextToken().equals("1") ? 1 : -1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = find(Integer.parseInt(st.nextToken()) - 1);
            int b = find(Integer.parseInt(st.nextToken()) - 1);

            if (a == b) continue;

            root[Math.max(a, b)] = Math.min(a, b);
            count[Math.min(a, b)] += count[Math.max(a, b)];
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            sb.append(count[find(Integer.parseInt(br.readLine()) - 1)] > 0 ? "1" : "0").append("\n");
        }

        System.out.println(sb);
    }

    static int find(int a) {

        if (a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}
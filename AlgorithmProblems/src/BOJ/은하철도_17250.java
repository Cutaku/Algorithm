package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 은하철도_17250 {
    static int[] root, cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        root = new int[n];
        cnt = new int[n];

        for (int i = 0; i < n; i++) {
            root[i] = i;
            cnt[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = find(Integer.parseInt(st.nextToken()) - 1);
            int b = find(Integer.parseInt(st.nextToken()) - 1);

            if (a > b) {
                int tmp = a;
                a = b;
                b = tmp;
            }

            if (a != b) {
                cnt[a] += cnt[b];
                root[b] = a;
            }

            sb.append(cnt[a]).append("\n");
        }

        System.out.println(sb);
    }

    static int find(int a) {

        if (root[a] == a) return a;
        return root[a] = find(root[a]);
    }
}
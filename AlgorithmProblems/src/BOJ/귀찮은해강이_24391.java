package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 귀찮은해강이_24391 {
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        root = new int[n];
        for (int i = 0; i < n; i++) root[i] = i;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = find(Integer.parseInt(st.nextToken()) - 1), b = find(Integer.parseInt(st.nextToken()) - 1);

            root[Math.max(a, b)] = Math.min(a, b);
        }

        st = new StringTokenizer(br.readLine());
        int last = Integer.parseInt(st.nextToken()) - 1;

        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            int next = Integer.parseInt(st.nextToken()) - 1;

            if (find(last) != find(next)) count++;

            last = next;
        }

        System.out.println(count);
    }

    static int find(int a) {

        if (a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}
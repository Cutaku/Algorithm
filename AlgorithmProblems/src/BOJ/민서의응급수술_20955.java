package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 민서의응급수술_20955 {
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        root = new int[n];
        for (int i = 0; i < n; i++) root[i]= i;

        int count = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = find(Integer.parseInt(st.nextToken()) - 1);
            int b = find(Integer.parseInt(st.nextToken()) - 1);

            if (a != b) {
                root[Math.max(a, b)] = Math.min(a, b);
            } else {
                count++;
            }
        }

        System.out.println(2 * count + n - m - 1);
    }

    static int find(int a) {

        if (a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}
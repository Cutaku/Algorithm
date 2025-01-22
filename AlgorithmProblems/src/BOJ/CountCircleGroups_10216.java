package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountCircleGroups_10216 {
    static int[] root;
    static int[][] camps;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int componets = n;

            root = new int[n];
            camps = new int[n][];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                root[i] = i;
                camps[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

                for (int j = 0; j < i; j++) {
                    int a = find(i), b = find(j);

                    if (a != b && intersect(i, j)) {
                        root[Math.max(a, b)] = Math.min(a, b);
                        componets--;
                    }
                }
            }

            sb.append(componets).append("\n");
        }

        System.out.println(sb);
    }

    static boolean intersect(int i, int j) {

        int dx = camps[i][0] - camps[j][0], dy = camps[i][1] - camps[j][1];
        int d = dx * dx + dy * dy;
        int r = camps[i][2] + camps[j][2];

        return r * r >= d;
    }

    static int find(int a) {

        if (a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}
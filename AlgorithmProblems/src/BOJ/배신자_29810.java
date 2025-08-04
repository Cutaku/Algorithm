package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배신자_29810 {
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[][] relations = new int[m][];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            relations[i] = new int[]{Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1};
        }

        int betrayer = Integer.parseInt(br.readLine()) - 1;

        root = new int[n];
        int[] count = new int[n];

        for (int i = 0; i < n; i++) {
            root[i] = i;
            count[i] = 1;
        }

        int[] bCount = new int[n];

        for (int i = 0; i < m; i++) {
            int a = find(relations[i][0]);
            int b = find(relations[i][1]);

            if (a == betrayer || b == betrayer) {
                bCount[a + b - betrayer]++;
                continue;
            }

            if (a == b) continue;

            root[Math.max(a, b)] = Math.min(a, b);
            count[Math.min(a, b)] += count[Math.max(a, b)];
            bCount[Math.min(a, b)] += bCount[Math.max(a, b)];
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            if (i != find(i)) continue;

            max = Math.max(max, count[i] + (bCount[i] == 1 ? 1 : 0));
        }

        System.out.println(max);
    }

    static int find(int a) {

        if (a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 사이클게임_20040 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        boolean[] used = new boolean[n];
        int[] root = new int[n];

        for (int i = 1; i <= m; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int v1 = edge[0], v2 = edge[1];

            if (!used[v1] && !used[v2]) {
                used[v1] = true;
                used[v2] = true;
            } else if (!used[v1] && used[v2]) {
                used[v1] = true;

                v2 = findRoot(v2, root);
            } else if (used[v1] && !used[v2]) {
                used[v2] = true;

                v1 = findRoot(v1, root);
            } else {
                v1 = findRoot(v1, root);
                v2 = findRoot(v2, root);

                if (v1 == v2) {
                    System.out.println(i);
                    return;
                }
            }

            int min = Math.min(v1, v2);
            root[v1] = min;
            root[v2] = min;
        }

        System.out.println(0);
    }

    static int findRoot(int r, int[] root) {

        while (r > root[r]) {
            r = root[r];
        }

        return r;
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 트리_1068 {
    static int n;
    static int[] parent;
    static int delete;
    static boolean[] isLeaf;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        parent = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        delete = Integer.parseInt(br.readLine());

        isLeaf = new boolean[n];
        Arrays.fill(isLeaf, true);

        for (int i = 0; i < n; i++) {
            if (parent[i] >= 0) isLeaf[parent[i]] = false;
        }

        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                System.out.println(findLeaf(i));
                return;
            }
        }
    }

    static int findLeaf(int node) {

        if (node == delete) return 0;
        if (isLeaf[node]) return 1;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (parent[i] == node) sum += findLeaf(i);
        }

        return Math.max(1, sum);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 로봇청소기_34060 {
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        root = new int[n];
        for (int i = 1; i < n; i++) root[i] = i;


        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        int last = 0;
        int m = n;

        for (int i = 0; i < n; i++) {
            int y = Integer.parseInt(br.readLine());

            if (y <= last) {
                map1 = map2;
                map2 = new HashMap<>();
            }

            last = y;

            map2.put(y, i);

            if (map1.containsKey(y)) {
                if (union(i, map1.get(y))) m--;
            }

            if (map2.containsKey(y - 1)) {
                if (union(i, map2.get(y - 1))) m--;
            }
        }

        System.out.println(m);
        System.out.println(n);
    }

    static boolean union(int i, int j) {

        int a = find(i);
        int b = find(j);

        if (a == b) return false;

        root[Math.max(a, b)] = Math.min(a, b);

        return true;
    }

    static int find(int a) {

        if (a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}
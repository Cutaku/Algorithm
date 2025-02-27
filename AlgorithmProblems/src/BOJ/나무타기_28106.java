package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 나무타기_28106 {
    static int n;
    static List<Integer>[] children;
    static int[] power;
    static int d = 998244353;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        children = new List[n];
        power = new int[n];

        for (int i = 0; i < n; i++) children[i] = new ArrayList<>();

        int root = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());

            if (p == 0) {
                root = i;
                continue;
            }

            children[p - 1].add(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) power[i] = Integer.parseInt(st.nextToken());

        System.out.println(dfs(root)[0]);
    }

    static int[] dfs(int i) {

        int[] res = new int[n];
        res[0] = children[i].isEmpty() ? 1 : 0;

        for (int child : children[i]) {
            int[] childRes = dfs(child);

            for (int j = 0; j < n; j++) {
                if (j < power[i]) res[0] = (res[0] + childRes[j]) % d;
                if (j < n - 1) res[j + 1] = (res[j + 1] + childRes[j]) % d;
            }
        }

        return res;
    }
}
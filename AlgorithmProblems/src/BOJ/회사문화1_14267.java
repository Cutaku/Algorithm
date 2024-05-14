package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 회사문화1_14267 {
    static List<Integer>[] children;
    static int[] sum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        children = new List[n];
        for (int i = 0; i < n; i++) children[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        st.nextToken();

        for (int i = 1; i < n; i++) {
            children[Integer.parseInt(st.nextToken()) - 1].add(i);
        }

        sum = new int[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            sum[Integer.parseInt(st.nextToken()) - 1] += Integer.parseInt(st.nextToken());
        }

        dfs(0);

        for (int s : sum) {
            sb.append(s).append(" ");
        }

        System.out.println(sb);
    }

    static void dfs(int node) {

        for (int child : children[node]) {
            sum[child] += sum[node];
            dfs(child);
        }
    }
}
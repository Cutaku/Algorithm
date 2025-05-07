package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리를복잡하게색칠하는최소비용_25690 {
    static List<Integer>[] children;
    static int[][] cost;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        children = new List[n];
        for (int i = 0; i < n; i++) children[i] = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            children[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        cost = new int[n][];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            cost[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        long[] min = findMin(0);

        System.out.println(Math.min(min[0], min[1]));
    }

    static long[] findMin(int node) {

        long[] res = new long[]{cost[node][0], cost[node][1]};

        for (int c : children[node]) {
            long[] cRes = findMin(c);

            res[0] += Math.min(cRes[0], cRes[1]);
            res[1] += cRes[0];
        }

        return res;
    }
}
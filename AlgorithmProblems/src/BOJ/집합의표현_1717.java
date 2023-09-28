package BOJ;

import java.io.*;
import java.util.Arrays;

public class 집합의표현_1717 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        int[] roots = new int[n + 1];
        for (int i = 0; i <= n; i++) roots[i] = i;

        for (int i = 0; i < m; i++) {
            int[] query = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int r1 = findRoot(roots, query[1]);
            int r2 = findRoot(roots, query[2]);

            if (query[0] == 0) {
                roots[r1] = Math.min(r1, r2);
                roots[r2] = Math.min(r1, r2);
            } else {
                if (r1 == r2) bw.append("YES\n");
                else bw.append("NO\n");
            }
        }

        bw.flush();
    }

    public static int findRoot(int[] roots, int n) {

        if (n == roots[n]) return n;
        else return roots[n] = findRoot(roots, roots[n]);
    }
}
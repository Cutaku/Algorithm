package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 벽장문의이동_2666 {
    static int n;
    static int m;
    static int[] closets;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int[] lr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int l = lr[0], r = lr[1];

        m = Integer.parseInt(br.readLine());

        closets = new int[m];
        for (int i = 0; i < m; i++) closets[i] = Integer.parseInt(br.readLine());

        System.out.println(dfs(l, r, 0, 0));
    }

    public static int dfs(int l, int r, int sum, int d) {

        if (d == m) {
            return sum;
        }

        int next = closets[d];

        if (next <= l) {
            return dfs(next, r, sum + l - next, d + 1);
        } else if (r <= next) {
            return dfs(l, next, sum + next - r, d + 1);
        } else {
            return Math.min(dfs(next, r, sum + next - l, d + 1),
                    dfs(l, next, sum + r - next, d + 1));
        }
    }
}
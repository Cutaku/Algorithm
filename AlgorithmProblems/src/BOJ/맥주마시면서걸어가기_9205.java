package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 맥주마시면서걸어가기_9205 {
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[][] points = new int[n + 2][2];

            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());

                points[i][0] = Integer.parseInt(st.nextToken());
                points[i][1] = Integer.parseInt(st.nextToken());
            }

            root = new int[n + 2];
            for (int i = 1; i < n + 2; i++) root[i] = i;

            for (int i = 0; i < n + 1; i++) {
                for (int j = i + 1; j < n + 2; j++) {
                    if (Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]) > 1000) continue;

                    int a = findRoot(i);
                    int b = findRoot(j);

                    if (a != b) {
                        root[Math.max(a, b)] = Math.min(a, b);
                    }
                }
            }

            if (findRoot(0) == findRoot(n + 1)) System.out.println("happy");
            else System.out.println("sad");
        }
    }

    static int findRoot(int a) {

        if (a == root[a]) return a;
        else return root[a] = findRoot(root[a]);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 교수님은기다리지않는다_3830 {
    static int[] root;
    static long[] dif;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) break;

            root = new int[n + 1];
            dif = new long[n + 1];

            for (int i = 1; i <= n; i++) root[i] = i;

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                if (st.nextToken().equals("!")) {
                    Compare a = find(Integer.parseInt(st.nextToken()));
                    Compare b = find(Integer.parseInt(st.nextToken()));

                    long d = Long.parseLong(st.nextToken());

                    if (a.root != b.root) {
                        d += a.dif - b.dif;

                        if (a.root < b.root) {
                            root[b.root] = a.root;
                            dif[b.root] = d;
                        } else {
                            root[a.root] = b.root;
                            dif[a.root] = -d;
                        }
                    }
                } else {
                    Compare a = find(Integer.parseInt(st.nextToken()));
                    Compare b = find(Integer.parseInt(st.nextToken()));

                    if (a.root == b.root) {
                        sb.append(b.dif - a.dif).append("\n");
                    } else {
                        sb.append("UNKNOWN\n");
                    }
                }
            }
        }

        System.out.println(sb);
    }

    static Compare find(int a) {

        if (a == root[a]) return new Compare(a, 0);

        Compare compare = find(root[a]);

        if (root[a] != compare.root) {
            dif[a] += compare.dif;
            root[a] = compare.root;
        }

        return new Compare(root[a], dif[a]);
    }

    static class Compare {
        int root;
        long dif;

        public Compare(int root, long dif) {
            this.root = root;
            this.dif = dif;
        }
    }
}
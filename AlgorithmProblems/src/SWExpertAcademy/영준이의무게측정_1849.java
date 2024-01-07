package SWExpertAcademy;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 영준이의무게측정_1849 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            bw.append("#").append(String.valueOf(tc)).append(" ");

            int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = nm[0], m = nm[1];

            int[] roots = new int[n + 1];
            for (int i = 0; i <= n; i++) roots[i] = i;

            long[] dif = new long[n + 1];

            for (int q = 0; q < m; q++) {
                st = new StringTokenizer(br.readLine());

                if (st.nextToken().equals("!")) {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    long d = Long.parseLong(st.nextToken());

                    int ra = findRoot(roots, dif, a);
                    int rb = findRoot(roots, dif, b);
                    d += dif[a] - dif[b];

                    if (ra > rb) {
                        int t = ra;
                        ra = rb;
                        rb = t;
                        d *= -1;
                    }

                    roots[rb] = ra;
                    dif[rb] = d;
                } else {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());

                    int ra = findRoot(roots, dif, a);
                    int rb = findRoot(roots, dif, b);

                    if (ra == rb) bw.append(String.valueOf(dif[b] - dif[a])).append(" ");
                    else bw.append("UNKNOWN ");
                }
            }

            bw.append("\n");
        }

        bw.flush();
    }

    public static int findRoot(int[] roots, long[] dif, int a) {

        Stack<Integer> s = new Stack<>();

        while (a != roots[a]) {
            s.add(a);
            a = roots[a];
        }

        long d = 0;

        while (!s.isEmpty()) {
            dif[s.peek()] += d;
            d = dif[s.peek()];

            roots[s.pop()] = a;
        }

        return a;
    }
}
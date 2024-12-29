package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 신촌통폐합계획_31423 {
    static int[] right;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long start = (long) n * (n - 1) / 2;

        String[] names = new String[n];
        right = new int[n];

        for (int i = 0; i < n; i++) {
            names[i] = br.readLine();
            right[i] = i;
        }

        int[] next = new int[n];

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1, b = Integer.parseInt(st.nextToken()) - 1;

            next[find(a)] = b;
            right[a] = find(b);

            start -= b;
        }

        int idx = (int) start;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(names[idx]);

            idx = next[idx];
        }

        System.out.println(sb);
    }

    static int find(int a) {

        if (a == right[a]) return a;
        return right[a] = find(right[a]);
    }
}
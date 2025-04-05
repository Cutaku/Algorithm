package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class aFanEventPlanning_27869 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken());

        long[] sum = new long[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + Long.parseLong(st.nextToken());

        TreeSet<Integer> cut = new TreeSet<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            if (st.nextToken().charAt(0) == '1') {
                cut.add(Integer.parseInt(st.nextToken()));
            } else {
                int s = Integer.parseInt(st.nextToken()) - 1;
                int e = Integer.parseInt(st.nextToken());

                Integer l = cut.lower(e);

                if (l != null) s = Math.max(s, l);

                sb.append(sum[e] - sum[s]).append("\n");
            }
        }

        System.out.println(sb);
    }
}
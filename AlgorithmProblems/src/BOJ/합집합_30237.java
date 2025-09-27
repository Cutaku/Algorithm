package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 합집합_30237 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T =  Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long u = 0;

            long[] sets = new long[n];
            long[] includes = new long[50];

            for (int i = 0; i < n; i++) {
                st =  new StringTokenizer(br.readLine());
                int k =  Integer.parseInt(st.nextToken());

                for (int j = 0; j < k; j++) {
                    int s =  Integer.parseInt(st.nextToken()) - 1;

                    sets[i] |= 1L << s;
                    includes[s] |= 1L << i;
                }

                u |= sets[i];
            }

            int max = 0;

            for (int i = 0; i < 50; i++) {
                if ((u & (1L << i)) == 0) continue;

                long v = 0;

                for (int j = 0; j < n; j++) {
                    if (includes[i] % 2 == 0) v |= sets[j];

                    includes[i] /= 2;
                }

                if (v < u) max = Math.max(max, Long.bitCount(v));
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 자석_28303 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int energy = Integer.parseInt(st.nextToken());

        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        long m = 0, M = 0;

        for (int i = 0; i < n - 1; i++) {
            int e = Integer.parseInt(st.nextToken());
            int d = e - energy;
            energy = e;

            m += d + k;
            M += d - k;

            min = Math.min(m, min);
            max = Math.max(M, max);

            if (m > 0) m = 0;
            if (M < 0) M = 0;
        }

        System.out.println(Math.max(max, -min));
    }
}
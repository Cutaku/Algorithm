package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오름차순최단경로_33706 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        boolean[] v = new boolean[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();

            v[Integer.parseInt(st.nextToken()) - 1] = true;
        }

        for (int i = 1; i < n; i++) {
            if (!v[i]) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 경쟁적전염_18405 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        List<int[]> virus = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int v = Integer.parseInt(st.nextToken());

                if (v > 0) virus.add(new int[]{i, j, v});
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()) - 1, y = Integer.parseInt(st.nextToken()) - 1;

        int dist = 40000;
        int min = 0;

        for (int[] v : virus) {
            int d = Math.abs(x - v[0]) + Math.abs(y - v[1]);

            if (d > s) continue;

            if (d < dist) {
                dist = d;
                min = v[2];
            } else if (d == dist) {
                min = Math.min(min, v[2]);
            }
        }

        System.out.println(min == 1001 ? 0 : min);
    }
}
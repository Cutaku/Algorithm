package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 방사능_5631 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n;
        int t = 1;

        while ((n = Integer.parseInt(br.readLine())) > 0) {
            sb.append("Case ").append(t++).append(":\n");

            int[][] home = new int[n][2];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                home[i][0] = Integer.parseInt(st.nextToken());
                home[i][1] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            int ax = Integer.parseInt(st.nextToken());
            int ay = Integer.parseInt(st.nextToken());
            int bx = Integer.parseInt(st.nextToken());
            int by = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int[] da = new int[n];
            int[] db = new int[n];

            for (int i = 0; i < n; i++) {
                da[i] = (home[i][0] - ax) * (home[i][0] - ax) + (home[i][1] - ay) * (home[i][1] - ay);
                db[i] = (home[i][0] - bx) * (home[i][0] - bx) + (home[i][1] - by) * (home[i][1] - by);
            }

            Arrays.sort(da);
            Arrays.sort(db);

            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine());

                int r1 = Integer.parseInt(st.nextToken());
                r1 *= r1;

                int r2 = Integer.parseInt(st.nextToken());
                r2 *= r2;

                sb.append(n - Math.min(count(da, r1) + count(db, r2), n)).append("\n");
            }
        }

        System.out.println(sb);
    }

    static int count(int[] arr, int a) {

        if (arr[0] > a) return 0;

        int s = 0, e = arr.length;

        while (e - s > 1) {
            int m = (s + e) / 2;

            if (arr[m] > a) e = m;
            else s = m;
        }

        return e;
    }
}
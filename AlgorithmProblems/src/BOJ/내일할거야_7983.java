package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 내일할거야_7983 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] assignments = new int[n][];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            assignments[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(assignments, Comparator.comparingInt(a -> -a[1]));

        int last = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (last <= assignments[i][1]) {
                last -= assignments[i][0];
            } else {
                last = assignments[i][1] - assignments[i][0];
            }
        }

        System.out.println(last);
    }
}
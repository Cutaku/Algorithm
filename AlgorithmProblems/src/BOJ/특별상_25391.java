package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 특별상_25391 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        int[][] scores = new int[n][];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            scores[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(scores, Comparator.comparingInt(a -> -a[1]));

        long ans = 0;

        for (int i = 0; i < k; i++) {
            ans += scores[i][0];
            scores[i][0] = -1;
        }

        Arrays.sort(scores, Comparator.comparingInt(a -> -a[0]));

        for (int i = 0; i < m; i++) {
            ans += scores[i][0];
        }

        System.out.println(ans);
    }
}
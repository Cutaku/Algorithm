package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 회의실배정_30827 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        int[][] meetings = new int[n][];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            meetings[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(meetings, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        int ans = 0;
        int[] ends = new int[k];

        for (int i = 0; i < n; i++) {
            Arrays.sort(ends);

            for (int j = k - 1; j >= 0; j--) {
                if (meetings[i][0] > ends[j]) {
                    ends[j] = meetings[i][1];
                    ans++;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}
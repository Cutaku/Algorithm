package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 달력_20207 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] last = new int[n];

        int[][] schedules = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            schedules[i][0] = Integer.parseInt(st.nextToken());
            schedules[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(schedules, (s1, s2) -> {
            if (s1[0] == s2[0]) return s2[1] - s1[1];
            return s1[0] - s2[0];
        });

        int ans = 0;
        int s = -1, e = -1, h = 0;

        boolean fin = false;

        a: for (int i = 0; i < n; i++) {
            int[] schedule = schedules[i];

            if (e + 1 < schedule[0]) {
                ans += (e - s + 1) * h;

                last[0] = schedule[1];

                s = schedule[0];
                e = Math.max(e, schedule[1]);
                h = 1;
            } else {
                for (int j = 0; j < h; j++) {
                    if (last[j] < schedule[0]) {
                        last[j] = schedule[1];
                        e = Math.max(e, schedule[1]);
                        continue a;
                    }
                }

                last[h++] = schedule[1];
                e = Math.max(e, schedule[1]);
            }
        }

        ans += (e - s + 1) * h;

        System.out.println(ans);
    }
}
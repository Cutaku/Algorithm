package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 개업_13910 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[] pan = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) pan[i] = Integer.parseInt(st.nextToken());

        Set<Integer> cook = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j <= m; j++) {
                cook.add(pan[i] + pan[j]);
            }
        }


        int[] min = new int[n + 1];
        Arrays.fill(min, 100000);
        min[0] = 0;

        boolean flag = true;
        int cnt = 0;

        while (flag) {
            flag = false;
            cnt++;

            for (int c : cook) {
                for (int i = n; i >= c; i--) {
                    if (min[i - c] < cnt && min[i] > min[i - c] + 1) {
                        min[i] = min[i - c] + 1;
                        flag = true;
                    }
                }
            }

            if (min[n] < 100000) {
                System.out.println(min[n]);
                return;
            }
        }

        System.out.println(-1);
    }
}
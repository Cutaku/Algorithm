package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 컨닝_1014 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        List<Integer> list = new ArrayList<>();
        list.add(0);

        for (int i = 0; i < 10; i++) {
            List<Integer> temp = new ArrayList<>();

            for (int j : list) {
                temp.add(j << 1);

                if ((j & 1) == 0) temp.add((j << 1) + 1);
            }

            list = temp;
        }

        int s = list.size();

        int[] bicCount = new int[s];
        for (int i = 0; i < s; i++) bicCount[i] = Integer.bitCount(list.get(i));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
            int l = 1 << m;

            int[] classroom = new int[n];

            for (int i = 0; i < n; i++) {
                String line = br.readLine();

                int b = 0;

                for (int j = 0; j < m; j++) {
                    b <<= 1;
                    if (line.charAt(j) == 'x') b++;
                }

                classroom[i] = b;
            }

            int[] dp = new int[s];

            for (int i = 0; i < s; i++) {
                int b = list.get(i);

                if (b >= l) break;
                if ((b & classroom[0]) > 0) continue;

                dp[i] = bicCount[i];
            }

            for (int row = 1; row < n; row++) {
                int[] temp = new int[s];

                for (int i = 0; i < s; i++) {
                    int b1 = list.get(i);

                    if (b1 >= l) break;

                    for (int j = 0; j < s; j++) {
                        int b2 = list.get(j);

                        if (b2 >= l) break;

                        if ((b2 & ((b1 << 1) | (b1 >> 1) | classroom[row])) > 0) continue;

                        temp[j] = Math.max(temp[j], dp[i] + bicCount[j]);
                    }
                }

                dp = temp;
            }

            int max = 0;

            for (int i = 0; i < s; i++) {
                int b = list.get(i);

                if (b >= l) break;

                max = Math.max(max, dp[i]);
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }
}
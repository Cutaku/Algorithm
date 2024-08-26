package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 오름세_3745 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String input;

        while ((input = br.readLine()) != null && !input.isEmpty()) {

            int n = Integer.parseInt(input.trim());

            int[] lis = new int[n];
            Arrays.fill(lis, 100001);

            int c = 0;

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());

                if (lis[0] >= num) {
                    if (c == 0) c++;
                    lis[0] = num;
                    continue;
                }

                int s = 0, e = c;

                while (e - s > 1) {
                    int m = (s + e) >> 1;

                    if (lis[m] < num) s = m;
                    else e = m;
                }

                lis[e] = num;

                if (c == e) c++;
            }

            sb.append(c).append("\n");
        }

        System.out.println(sb);
    }
}
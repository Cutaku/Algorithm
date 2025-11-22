package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 운전연습_30640 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long maxA = Long.parseLong(st.nextToken()), maxF = Long.parseLong(st.nextToken());
        int sNum = 0;

        long fSum = maxF;

        boolean flag = true;

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (flag) {
                st = new StringTokenizer(br.readLine());
                long a = Long.parseLong(st.nextToken()), f = Long.parseLong(st.nextToken());

                if (fSum < a) {
                    flag = false;
                    sb.append("-1 -1\n");
                    continue;
                }

                fSum += f;

                sb.append(sNum).append(" ").append(maxF + maxA - a).append("\n");

                if (maxF + maxA <= a) {
                    sNum = i;
                    maxA = a;
                    maxF = f;
                } else {
                    maxF += f;
                }
            } else {
                sb.append("-1 -1\n");
            }
        }

        System.out.println(sb);
    }
}
package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class 한빈이와SpotMart_9229 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append('#').append(tc).append(' ');

            int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = nm[0], m = nm[1];

            int[] weights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

            if (weights[0] + weights[1] > m) {
                sb.append("-1\n");
                continue;
            }

            int s = 0;
            int e = n - 1;

            int max = 0;

            while (s < e) {
                int sum = weights[s] + weights[e];

                if (sum == m) {
                    max = m;
                    break;
                } else if (sum < m) {
                    max = Math.max(max, sum);
                    s++;
                } else {
                    e--;
                }
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 조삼모사_1621 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());

        long[] dp = new long[n + 1];
        boolean[] jump = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            int w = Integer.parseInt(st.nextToken());

            dp[i] = dp[i - 1] + w;

            if (i >= k && dp[i - k] + c < dp[i]) {
                dp[i] = dp[i - k] + c;
                jump[i] = true;
            }
        }

        Stack<Integer> stack = new Stack<>();

        int idx = n;

        while (idx > 0) {
            if (jump[idx]) {
                idx -= k;
                stack.push(idx + 1);
            } else {
                idx--;
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(dp[n]).append("\n");
        sb.append(stack.size()).append("\n");
        while (!stack.isEmpty()) sb.append(stack.pop()).append(" ");

        System.out.println(sb);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 호반우가학교에지각한이유3_30470 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                stack.push(new int[]{b, 1});
            } else {
                if (stack.isEmpty()) continue;

                int max = Math.max(stack.peek()[0] - b, 0);
                int c = 0;

                while (!stack.isEmpty() && stack.peek()[0] >= max) {
                    c += stack.pop()[1];
                }

                if (max > 0) {
                    stack.push(new int[]{max, c});
                }
            }
        }

        long ans = 0;

        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            ans += (long) pop[0] * pop[1];
        }

        System.out.println(ans);
    }
}
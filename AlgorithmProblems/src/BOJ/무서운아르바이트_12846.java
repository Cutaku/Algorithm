package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 무서운아르바이트_12846 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] heights = new long[n + 2];
        for (int i = 1; i <= n; i++) heights[i] = Long.parseLong(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        long max = 0;

        for (int i = 1; i < n + 2; i++) {
            while (heights[stack.peek()] > heights[i]) {
                max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
            }

            stack.push(i);
        }

        System.out.println(max);
    }
}
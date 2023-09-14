package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 히스토그램_1725 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] heights = new int[n + 2];
        for (int i = 1; i <= n; i++) heights[i] = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int max = 0;

        for (int i = 1; i < n + 2; i++) {
            while (heights[stack.peek()] > heights[i]) {
                max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
            }

            stack.push(i);
        }

        System.out.println(max);
    }
}
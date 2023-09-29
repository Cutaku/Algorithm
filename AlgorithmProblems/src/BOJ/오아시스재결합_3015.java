package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 오아시스재결합_3015 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] heights = new int[n + 1];
        for (int i = 0; i < n; i++) heights[i] = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        long sum = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                sum += i - stack.pop();
            }

            stack.add(i);
        }

        int s = stack.size();

        int[] left = new int[s];

        for (int i = s - 1; i >= 0; i--) {
            left[i] = stack.pop();
        }

        System.out.println(sum);
    }
}
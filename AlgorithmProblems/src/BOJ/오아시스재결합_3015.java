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

        Stack<int[]> stack = new Stack<>();

        long sum = 0;

        for (int i = 0; i < n; i++) {
            int height = heights[i];

            int[] last = new int[]{0, 0};

            while (!stack.isEmpty() && stack.peek()[0] <= height) {
                last = stack.pop();
                sum += last[1];
            }

            if (!stack.isEmpty()) sum++;

            if (last[0] == height) {
                last[1]++;
                stack.add(last);
            } else {
                stack.add(new int[]{height, 1});
            }
        }

        System.out.println(sum);
    }
}
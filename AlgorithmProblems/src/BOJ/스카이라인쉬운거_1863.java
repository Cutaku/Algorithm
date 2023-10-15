package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class 스카이라인쉬운거_1863 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int count = 0;

        for (int i = 0; i < n; i++) {
            int[] shade = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int height = shade[1];

            while (stack.peek() > height) {
                stack.pop();
            }

            if (stack.peek() < height) {
                count++;
                stack.push(height);
            }
        }

        System.out.println(count);
    }
}
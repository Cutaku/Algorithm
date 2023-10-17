package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class 탑_2493 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] towers = Arrays.stream(("100000000 " + br.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i <= n; i++) {
            while (towers[stack.peek()] < towers[i]) {
                stack.pop();
            }

            bw.append(String.valueOf(stack.peek())).append(" ");
            stack.push(i);
        }

        bw.flush();
    }
}
package BOJ;

import java.io.*;
import java.util.Stack;

public class 후위표기식_1918 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        Stack<Character> stack = new Stack<>();

        int[] map = new int[200];
        map['/'] = 1;
        map['*'] = 1;

        int i = 0;

        while (i < input.length()) {
            char c = input.charAt(i++);

            if (c >= 'A' && c <= 'Z') {
                bw.append(c);
            } else if (c == ')') {
                while (stack.peek() != '(') {
                    bw.append(stack.pop());
                }

                stack.pop();
            } else if (c == '(') {
                stack.add(c);

            } else {
                while (!stack.isEmpty() && stack.peek() != '(' && map[stack.peek()] >= map[c]) {
                    bw.append(stack.pop());
                }

                stack.add(c);
            }
        }

        while (!stack.isEmpty()) {
            bw.append(stack.pop());
        }

        bw.flush();
    }
}
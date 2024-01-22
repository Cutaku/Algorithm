package BOJ;

import java.io.*;
import java.util.Stack;

public class 단어뒤집기2_17413 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int l = str.length();

        boolean isTag = false;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < l; i++) {
            char c = str.charAt(i);

            if (c == '<') isTag = true;

            if (isTag || c == ' ') {
                while (!stack.isEmpty()) bw.append(stack.pop());
                bw.append(c);
            } else {
                stack.push(c);
            }

            if (c == '>') isTag = false;
        }

        while (!stack.isEmpty()) bw.append(stack.pop());

        bw.flush();
    }
}
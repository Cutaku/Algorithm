package BOJ;

import java.io.*;
import java.util.Stack;

public class 문자열폭발_9935 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] string = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();

        int l = bomb.length;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < string.length; i++) {
            stack.add(string[i]);

            if (stack.size() < l) continue;

            int d = 0;
            while (d < l && stack.get(stack.size() - 1 - d) == bomb[l - 1 - d]) d++;

            if (d == l) {
                for (int j = 0; j < l; j++) stack.pop();
            }
        }

        if (stack.size() == 0) {
            System.out.println("FRULA");
        } else {
            for (int i = 0; i < stack.size(); i++) {
                bw.append(stack.get(i));
            }

            bw.flush();
        }
    }
}
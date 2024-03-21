package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 추월_2002 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), i);
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int idx = map.get(br.readLine());

            while (!stack.isEmpty() && stack.peek() > idx) stack.pop();

            stack.push(idx);
        }

        System.out.println(n - stack.size());
    }
}
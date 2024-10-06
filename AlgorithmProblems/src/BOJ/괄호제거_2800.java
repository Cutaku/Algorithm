package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class 괄호제거_2800 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        String input = br.readLine();

        Stack<Integer> stack = new Stack<>();
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push(i);
            } else if (input.charAt(i) == ')') {
                list.add(new int[]{stack.pop(), i});
            }
        }

        int l = list.size();

        int[] toIdx = new int[(1 << (l - 1)) + 1];
        for (int i = 0; i < l; i++) toIdx[1 << i] = i;

        TreeSet<String> ans = new TreeSet<>();

        for (int i = 1; i < 1 << l; i++) {
            boolean[] remove = new boolean[input.length()];

            int idx = i;

            while (idx > 0) {
                int j = idx & -idx;
                idx -= j;

                int[] bracket = list.get(toIdx[j]);

                remove[bracket[0]] = true;
                remove[bracket[1]] = true;
            }

            sb = new StringBuilder();

            for (int j = 0; j < input.length(); j++) {
                if (!remove[j]) sb.append(input.charAt(j));
            }

            ans.add(sb.toString());
        }

        sb = new StringBuilder();

        while (!ans.isEmpty()) {
            sb.append(ans.pollFirst()).append("\n");

        }

        System.out.println(sb);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class 일로만들기2_12852 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] before = new int[n];

        Queue<Integer> q = new ArrayDeque<>();
        q.add(n);

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == 1) break;

            if (now % 3 == 0 && before[now / 3] == 0) {
                q.add(now / 3);
                before[now / 3] = now;
            }

            if (now % 2 == 0 && before[now / 2] == 0) {
                q.add(now / 2);
                before[now / 2] = now;
            }

            if (before[now - 1] == 0) {
                q.add(now - 1);
                before[now - 1] = now;
            }
        }

        int ans = 0;
        Stack<Integer> stack = new Stack<>();

        int m = 1;

        while (m < n) {
            ans++;
            stack.add(m);
            m = before[m];
        }

        StringBuilder sb = new StringBuilder();

        sb.append(ans).append("\n");
        sb.append(n).append(" ");

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }
}
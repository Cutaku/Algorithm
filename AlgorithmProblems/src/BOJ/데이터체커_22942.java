package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class 데이터체커_22942 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] intervals = new int[n][];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            intervals[i] = new int[]{x - r, x + r};
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        Stack<Integer> stack = new Stack<>();
        stack.push(intervals[0][1]);

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] == intervals[i - 1][0]) {
                System.out.println("NO");
                return;
            }

            while (!stack.isEmpty() && stack.peek() < intervals[i][0]) {
                stack.pop();
            }

            if (!stack.isEmpty() && (stack.peek() == intervals[i][0] || stack.peek() <= intervals[i][1])) {
                System.out.println("NO");
                return;
            }

            stack.push(intervals[i][1]);
        }

        System.out.println("YES");
    }
}
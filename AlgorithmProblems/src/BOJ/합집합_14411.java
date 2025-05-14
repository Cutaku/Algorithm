package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 합집합_14411 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[][] arr = new long[n][];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i] = new long[]{Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())};
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) return Long.compare(a[1], b[1]);
            return Long.compare(a[0], b[0]);
        });

        Stack<long[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i][1] >= stack.peek()[1]) {
                stack.pop();
            }

            stack.push(arr[i]);
        }

        long res = 0;
        long last = 0;

        while (!stack.isEmpty()) {
            long[] rect = stack.pop();

            res += rect[0] * (rect[1] - last);
            last = rect[1];
        }

        System.out.println(res);
    }
}
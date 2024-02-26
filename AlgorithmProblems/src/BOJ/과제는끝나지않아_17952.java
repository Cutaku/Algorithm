package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 과제는끝나지않아_17952 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Stack<int[]> tasks = new Stack<>();

        int[] last = null;

        int score = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());

            if (m == 1) {
                tasks.push(last);

                last = new int[2];

                last[0] = Integer.parseInt(st.nextToken());
                last[1] = Integer.parseInt(st.nextToken());
            }

            if (last != null) {
                if (--last[1] == 0) {
                    score += last[0];
                    last = tasks.pop();
                }
            }
        }

        System.out.println(score);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 숨바꼭질4_13913 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0];
        int k = nk[1];
        int m = Math.max(n+1, 2*k+1);
        int count = 0;

        int[] check = new int[m];
        Arrays.fill(check, -2);

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        q1.add(n);
        check[n] = -1;

        while (true) {
            int s = q1.poll();

            if (s == k) {
                System.out.println(count);
                Stack<Integer> st = new Stack<>();
                st.push(s);
                int i = s;

                while (check[i] > -1) {
                    st.push(check[i]);
                    i = check[i];
                }

                while (!st.isEmpty()) {
                    sb.append(st.pop() + " ");
                }
                System.out.println(sb.toString());
                return;
            }

            if (s < k && check[s+1] == -2) {
                q2.add(s+1);
                check[s+1] = s;
            }
            if (s > 0 && check[s-1] == -2) {
                q2.add(s-1);
                check[s-1] = s;
            }
            if (s < k && check[2*s] == -2) {
                q2.add(2*s);
                check[2*s] = s;
            }

            if (q1.isEmpty()) {
                q1 = q2;
                q2 = new LinkedList<>();
                count++;
            }
        }
    }
}
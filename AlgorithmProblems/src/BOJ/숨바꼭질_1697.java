package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 숨바꼭질_1697 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0];
        int k = nk[1];
        int m = Math.max(n+1, 2*k+1);
        int count = 0;

        boolean[] check = new boolean[m];

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        q1.add(n);
        check[n] = true;

        while (true) {
            int s = q1.poll();

            if (s == k) {
                System.out.println(count);
                return;
            }

            if (s < k && !check[s+1]) {
                q2.add(s+1);
                check[s+1] = true;
            }
            if (s > 0 && !check[s-1]) {
                q2.add(s-1);
                check[s-1] = true;
            }
            if (s < k && !check[2*s]) {
                q2.add(2*s);
                check[2*s] = true;
            }

            if (q1.isEmpty()) {
                q1 = q2;
                q2 = new LinkedList<>();
                count++;
            }
        }
    }
}
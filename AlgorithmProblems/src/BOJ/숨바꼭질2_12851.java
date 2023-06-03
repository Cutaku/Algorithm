package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 숨바꼭질2_12851 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0], k = nk[1];

        if (n > k) {
            System.out.println(n - k);
            System.out.println(1);
            return;
        }

        int[] visited = new int[k + 2];
        Arrays.fill(visited, 200000);

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        q1.add(n);
        visited[n] = 0;

        int t = 0;
        int count = 0;
        boolean min = false;

        while (!q1.isEmpty()) {
            int now = q1.poll();

            if (now == k) {
                min = true;
                count++;
            }

            if (now > 0 && visited[now - 1] >= t) {
                q2.add(now - 1);
                visited[now - 1] = t;
            }

            if (now < k && visited[now + 1] >= t) {
                q2.add(now + 1);
                visited[now + 1] = t;
            }

            if (now * 2 < k + 2 && visited[now * 2] >= t) {
                q2.add(now * 2);
                visited[now * 2] = t;
            }

            if (q1.isEmpty() && !min) {
                q1 = q2;
                q2 = new LinkedList<>();
                t++;
            }
        }

        System.out.println(t);
        System.out.println(count);
    }
}
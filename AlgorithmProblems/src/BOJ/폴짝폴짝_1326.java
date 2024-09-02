package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 폴짝폴짝_1326 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        boolean[] v = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()) - 1, e = Integer.parseInt(st.nextToken()) - 1;

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        q1.add(s);
        v[s] = true;

        int t = 0;

        while (!q1.isEmpty()) {
            int now = q1.poll();

            if (now == e) {
                System.out.println(t);
                return;
            }

            for (int i = now + arr[now]; i < n; i += arr[now]) {
                if (!v[i]) {
                    v[i] = true;
                    q2.add(i);
                }
            }

            for (int i = now - arr[now]; i >= 0; i -= arr[now]) {
                if (!v[i]) {
                    v[i] = true;
                    q2.add(i);
                }
            }

            if (q1.isEmpty()) {
                Queue<Integer> tmp = q1;
                q1 = q2;
                q2 = tmp;

                t++;
            }
        }

        System.out.println(-1);
    }
}
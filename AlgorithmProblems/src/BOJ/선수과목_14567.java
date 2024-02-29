package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 선수과목_14567 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] pre = new int[n];
        int[] sem = new int[n];

        List<Integer>[] next = new List[n];
        for (int i = 0; i < n; i++) next[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            pre[to]++;

            next[from].add(to);
        }

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (pre[i] == 0) q1.add(i);
        }

        int s = 1;

        while (!q1.isEmpty()) {
            int from = q1.poll();

            sem[from] = s;

            for (int to : next[from]) {
                pre[to]--;

                if (pre[to] == 0) q2.add(to);
            }

            if (q1.isEmpty()) {
                Queue<Integer> temp = q1;
                q1 = q2;
                q2 = temp;

                s++;
            }
        }

        for (int a : sem) {
            sb.append(a).append(' ');
        }

        System.out.println(sb);
    }
}
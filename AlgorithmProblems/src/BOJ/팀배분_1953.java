package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 팀배분_1953 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            
            int c = Integer.parseInt(st.nextToken());

            for (int j = 0; j < c; j++) {
                adj[i].add(Integer.parseInt(st.nextToken()) - 1);
            }
        }

        PriorityQueue<Integer> blue = new PriorityQueue<>();
        PriorityQueue<Integer> white = new PriorityQueue<>();

        Queue<Integer> q = new ArrayDeque<>();
        int[] v = new int[n];

        for (int i = 0; i < n; i++) {
            if (v[i] > 0) continue;

            q.add(i);
            v[i] = 1;
            blue.add(i);

            while (!q.isEmpty()) {
                int now = q.poll();

                for (int next : adj[now]) {
                    if (v[next] > 0) continue;

                    q.add(next);
                    v[next] = 3 - v[now];

                    if (v[next] == 1) blue.add(next);
                    else white.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(blue.size()).append("\n");
        while (!blue.isEmpty()) sb.append(blue.poll() + 1).append(" ");
        sb.append("\n");

        sb.append(white.size()).append("\n");
        while (!white.isEmpty()) sb.append(white.poll() + 1).append(" ");

        System.out.println(sb);
    }
}
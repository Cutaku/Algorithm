package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 여행가자_1976 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[] neighbors = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < n; j++) {
                if (neighbors[j] == 1) adj[i].add(j);
            }

        }

        boolean[] connected = new boolean[n];
        int[] route = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Queue<Integer> q = new LinkedList<>();
        q.add(route[0] - 1);
        connected[route[0] - 1] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : adj[now]) {
                if (connected[next]) continue;

                q.add(next);
                connected[next] = true;
            }
        }

        for (int country : route) {
            if (!connected[country - 1]) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
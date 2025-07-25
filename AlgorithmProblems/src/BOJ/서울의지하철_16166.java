package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 서울의지하철_16166 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<Integer, Node> stations = new HashMap<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            Node line = new Node(-1);

            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());

            for (int j = 0; j < k; j++) {
                int a = Integer.parseInt(st.nextToken());

                Node station = stations.getOrDefault(a, new Node(a));
                stations.put(a, station);

                station.adj.add(line);
                line.adj.add(station);
            }
        }

        Node s = stations.get(0);
        int e = Integer.parseInt(br.readLine());

        if (e == 0) {
            System.out.println(0);
            return;
        }

        Queue<Node> q1 = new ArrayDeque<>();
        Queue<Node> q2 = new ArrayDeque<>();

        q1.add(s);
        s.visited = true;
        int cnt = 0;

        while (!q1.isEmpty()) {
            Node now = q1.poll();

            if (now.station == e) {
                System.out.println(cnt / 2 - 1);
                return;
            }

            for (Node next : now.adj) {
                if (next.visited) continue;

                q2.add(next);
                next.visited = true;
            }

            if (q1.isEmpty()) {
                cnt++;

                Queue<Node> tmp = q1;
                q1 = q2;
                q2 = tmp;
            }
        }

        System.out.println(-1);
    }

    static class Node {

        boolean visited = false;
        int station;
        List<Node> adj = new ArrayList<>();

        public Node(int station) {
            this.station = station;
        }
    }
}
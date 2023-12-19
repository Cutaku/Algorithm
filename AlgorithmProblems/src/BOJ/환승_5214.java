package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 환승_5214 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nkm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nkm[0], m = nkm[2];

        Node[] stations = new Node[n + 1];
        for (int i = 1; i <= n; i++) stations[i] = new Node(i);

        for (int i = 0; i < m; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Node tube = new Node(0);

            for (int j : input) {
                stations[j].adj.add(tube);
                tube.adj.add(stations[j]);
            }
        }

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.add(stations[1]);
        stations[1].v = true;

        int count = 2;

        while (!q1.isEmpty()) {
            Node now = q1.poll();

            if (now.number == n) {
                System.out.println(count / 2);
                return;
            }

            for (Node next : now.adj) {
                if (next.v) continue;
                next.v = true;
                q2.add(next);
            }


            if (q1.isEmpty()) {
                q1 = q2;
                q2 = new LinkedList<>();
                count++;
            }
        }

        System.out.println(-1);
    }

    public static class Node {

        int number;
        boolean v = false;
        List<Node> adj = new ArrayList<>();

        public Node(int number) {
            this.number = number;
        }
    }
}
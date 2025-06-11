package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최대유량_6086 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Edge[] edges = new Edge[2 * n + 1];
        int[] flows = new int[2 * n + 1];

        List<Integer>[] adj = new List['z' + 1];
        for (int i = 'A'; i <= 'Z'; i++) adj[i] = new ArrayList<>();
        for (int i = 'a'; i <= 'z'; i++) adj[i] = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            int f = Integer.parseInt(st.nextToken());

            edges[2 * i + 1] = new Edge(a, b, f);
            edges[2 * i + 2] = new Edge(b, a, f);

            adj[a].add(2 * i + 1);
            adj[b].add(2 * i + 2);
        }

        int ans = 0;

        a: while (true) {
            Queue<Node> q = new ArrayDeque<>();
            int[] before = new int['z' + 1];

            q.add(new Node('A', 10000));
            before['A'] = -1;

            while (!q.isEmpty()) {
                Node now = q.poll();

                if (now.c == 'Z') {
                    int e = before['Z'];
                    ans += now.flow;

                    while (e != -1) {
                        int d = e % 2 == 0 ? e - 1 : e + 1;

                        flows[e] += now.flow;
                        flows[d] -= now.flow;

                        e = before[edges[e].from];
                    }

                    continue a;
                }

                for (int next : adj[now.c]) {
                    Edge edge = edges[next];

                    if (before[edge.to] == 0 && flows[next] < edge.cap) {
                        before[edge.to] = next;
                        q.add(new Node(edge.to, Math.min(now.flow, edge.cap - flows[next])));
                    }
                }
            }

            break;
        }

        System.out.println(ans);
    }

    static class Edge {

        char from;
        char to;
        int cap;

        public Edge(char from, char to, int cap) {
            this.from = from;
            this.to = to;
            this.cap = cap;
        }
    }

    static class Node {

        char c;
        int flow;

        public Node(char c, int flow) {
            this.c = c;
            this.flow = flow;
        }
    }
}
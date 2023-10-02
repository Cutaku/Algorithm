package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 트리의독립집합_2213 {
    static int n;
    static int[] weights;
    static boolean[] visited;
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        weights = Arrays.stream(("0 " + br.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();

        visited = new boolean[n + 1];

        adj = new List[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        Result result = findMax(1);

        bw.append(String.valueOf(Math.max(result.on, result.off)));
        bw.append("\n");

        PriorityQueue pq;

        if (result.on > result.off)  pq = result.pq1;
        else pq = result.pq2;

        while (!pq.isEmpty()) {
            bw.append(String.valueOf(pq.poll()));
            bw.append(" ");
        }

        bw.flush();
    }

    public static Result findMax(int node) {

        visited[node] = true;

        Result result = new Result(weights[node], node);

        for (int c : adj[node]) {
            if (visited[c]) continue;

            Result r = findMax(c);

            result.on += r.off;
            result.pq1.addAll(r.pq2);

            if (r.on > r.off) {
                result.off += r.on;
                result.pq2.addAll(r.pq1);
            } else {
                result.off += r.off;
                result.pq2.addAll(r.pq2);
            }
        }

        return result;
    }

    public static class Result {
        int on;
        int off = 0;

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        public Result(int weight, int node) {
            this.on = weight;
            this.pq1.add(node);
        }
    }
}
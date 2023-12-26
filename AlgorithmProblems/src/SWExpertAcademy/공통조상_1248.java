package SWExpertAcademy;

import java.io.*;
import java.util.*;

public class 공통조상_1248 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int v = numbers[0], e = numbers[1], v1 = numbers[2], v2 = numbers[3];

            int[] parent = new int[v + 1];
            int[] depth = new int[v + 1];

            int[] edges = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            List<Integer>[] children = new List[v + 1];
            for (int i = 1; i <= v; i++) children[i] = new ArrayList<>();

            for (int i = 0; i < e; i++) {
                children[edges[i * 2]].add(edges[i * 2 + 1]);
            }

            Queue<Integer> q = new LinkedList<>();
            q.add(1);

            while (!q.isEmpty()) {
                int p = q.poll();

                for (int c : children[p]) {
                    q.add(c);
                    parent[c] = p;
                    depth[c] = depth[p] + 1;
                }
            }

            while (v1 != v2) {
                if (depth[v1] > depth[v2]) v1 = parent[v1];
                else if (depth[v2] > depth[v1]) v2 = parent[v2];
                else {
                    v1 = parent[v1];
                    v2 = parent[v2];
                }
            }

            bw.append("#").append(String.valueOf(t))
                    .append(" ").append(String.valueOf(v1))
                    .append(" ").append(String.valueOf(subTree(v1, children)))
                    .append("\n");
        }

        bw.flush();
    }

    public static int subTree(int n, List<Integer>[] children) {

        int sum = 1;

        for (int c : children[n]) {
            sum += subTree(c, children);
        }

        return sum;
    }
}
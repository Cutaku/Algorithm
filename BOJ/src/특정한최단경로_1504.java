import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 특정한최단경로_1504 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] ne = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = ne[0], e = ne[1];

        List<int[]>[] edges = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = edge[0];
            int b = edge[1];
            int c = edge[2];

            edges[a].add(new int[]{b, c});
            edges[b].add(new int[]{a, c});
        }

        int[] v12 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int v1 = v12[0], v2 = v12[1];

        int[] fromV1 = dijkstra(edges, v1);
        int[] fromV2 = dijkstra(edges, v2);

        int min = Math.min(fromV1[1] + fromV1[v2] + fromV2[n], fromV2[1] + fromV2[v1] + fromV1[n]);

        int inf = 800000;
        if (fromV1[v2] == inf || ((fromV1[1] == inf || fromV2[n] == inf) && (fromV2[1] == inf || fromV1[n] == inf)))
            System.out.println(-1);
        else System.out.println(min);
    }

    static int[] dijkstra(List<int[]>[] edges, int start) {
        int n = edges.length - 1;
        boolean[] fin = new boolean[n + 1];

        int[] result = new int[n + 1];
        int inf = 800000;
        Arrays.fill(result, inf);
        result[start] = 0;
        fin[start] = true;

        int i = start;

        while (i > 0) {
            for (int[] edge : edges[i]) {
                result[edge[0]] = Math.min(result[edge[0]], result[i] + edge[1]);
            }

            int min = inf;
            for (int j = 0; j <= n; j++) {
                if (!fin[j] && result[j] <= min) {
                    i = j;
                    min = result[j];
                }
            }

            fin[i] = true;
        }

        return result;
    }
}
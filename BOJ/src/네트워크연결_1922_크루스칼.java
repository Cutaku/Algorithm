import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 네트워크연결_1922_크루스칼 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()), m = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for (int i = 0; i < m; i++) q.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());

        int[] component = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            component[i] = i;
        }

        int sum = 0;
        int count = 0;

        while (!q.isEmpty()) {
            if (count == n - 1) break;

            int[] edge = q.poll();

            int c1 = find(edge[0], component),c2 = find(edge[1], component);
            if (c1 == c2) continue;

            component[c1] = Math.min(component[c1], component[c2]);
            component[c2] = component[c1];

            sum += edge[2];
            count++;
        }

        System.out.println(sum);
    }

    static int find(int n, int[] component) {
        int m = component[n];
        if (m == n) return m;
        else return find(m, component);
    }
}
package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 해킹_10282 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int[] ndc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = ndc[0], d = ndc[1], c = ndc[2];

            List<int[]>[] adj = new List[n + 1];
            for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();

            for (int i = 0; i < d; i++) {
                int[] dependency = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                adj[dependency[1]].add(new int[]{dependency[0], dependency[2]});
            }

            int[] min = new int[n + 1];
            Arrays.fill(min, Integer.MAX_VALUE);

            min[c] = 0;

            boolean[] fin = new boolean[n + 1];

            int i = findMin(min, fin);

            while (i > 0) {
                for (int[] next : adj[i]) {
                    min[next[0]] = Math.min(min[next[0]], min[i] + next[1]);
                }

                i = findMin(min, fin);
            }

            int count = 0;
            int max = 0;

            for (int j = 1; j <= n; j++) {
                if (min[j] < Integer.MAX_VALUE) {
                    count++;
                    max = Math.max(max, min[j]);
                }
            }

            bw.append(String.valueOf(count)).append(" ").append(String.valueOf(max)).append("\n");
        }

        bw.flush();
    }

    public static int findMin(int[] min, boolean[] fin) {

        int n = min.length - 1;

        int i = 0;

        int m = Integer.MAX_VALUE;

        for (int j = 1; j <= n; j++) {
            if (fin[j]) continue;

            if (min[j] < m) {
                i = j;
                m = min[j];
            }
        }

        fin[i] = true;

        return i;
    }
}
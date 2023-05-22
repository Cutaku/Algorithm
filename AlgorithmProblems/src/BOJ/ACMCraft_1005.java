package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ACMCraft_1005 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = nk[0], k = nk[1];

            int[] buildingTimes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] waitingTimes = new int[n];

            int[] post = new int[n];

            List<Integer>[] nexts = new List[n];
            for (int i = 0; i < n; i++) nexts[i] = new ArrayList<>();

            for (int i = 0; i < k; i++) {
                int[] rule = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                post[rule[1] - 1]++;

                nexts[rule[0] - 1].add(rule[1] - 1);
            }

            Queue<Integer> q = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                if (post[i] == 0) q.add(i);
            }

            int target = Integer.parseInt(br.readLine()) - 1;

            while (!q.isEmpty()) {
                int now = q.poll();

                buildingTimes[now] += waitingTimes[now];

                if (now == target) break;

                for (int next : nexts[now]) {
                    post[next]--;

                    waitingTimes[next] = Math.max(waitingTimes[next], buildingTimes[now]);

                    if (post[next] == 0) q.add(next);
                }
            }

            System.out.println(buildingTimes[target]);
        }
    }
}
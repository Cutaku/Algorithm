import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 작업_2056 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer>[] lists = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        int[] times = new int[n + 1];
        int[] pres = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < n + 1; i++) {
            int[] work = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            times[i] += work[0];
            pres[i] = work[1];

            if (work[1] == 0) {
                q.add(i);
            } else {
                for (int j = 2; j < 2 + work[1]; j++) {
                    lists[work[j]].add(i);
                }
            }
        }

        int[] totalTimes = new int[n + 1];
        int max = 0;

        while (!q.isEmpty()) {
            int m = q.poll();

            totalTimes[m] += times[m];
            max = Math.max(max, totalTimes[m]);

            for (int i : lists[m]) {
                totalTimes[i] = Math.max(totalTimes[i], totalTimes[m]);
                pres[i]--;

                if (pres[i] == 0) q.add(i);
            }
        }

        System.out.println(max);
    }
}
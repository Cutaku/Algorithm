package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 최소비용구하기2_11779 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<int[]>[] buses = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            buses[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int[] bus = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int from = bus[0];
            int to = bus[1];
            int cost = bus[2];

            buses[from].add(new int[]{to, cost});
        }

        int[] se = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start = se[0];
        int end = se[1];

        int[] before = new int[n + 1];
        boolean[] fin = new boolean[n + 1];

        int inf = 100000000;
        int[] costs = new int[n + 1];
        Arrays.fill(costs, inf);
        costs[start] = 0;
        fin[start] = true;

        int i = start;

        while (i > 0 && !fin[end]) {
            for (int[] bus : buses[i]) {
                if (costs[bus[0]] > costs[i] + bus[1]) {
                    before[bus[0]] = i;
                    costs[bus[0]] = costs[i] + bus[1];
                }
            }

            int min = inf;
            for (int j = 0; j <= n; j++) {
                if (!fin[j] && costs[j] < min) {
                    i = j;
                    min = costs[j];
                }
            }
            fin[i] = true;
        }

        System.out.println(costs[end]);

        StringBuilder str = new StringBuilder();
        str.append(end);
        int count = 1;

        while (end != start) {
            count++;
            end = before[end];
            str.insert(0, " ");
            str.insert(0, end);
        }

        System.out.println(count);
        System.out.println(str);
    }
}
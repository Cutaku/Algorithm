package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 음악프로그램_2623 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        List<Integer>[] next = new List[n + 1];
        for (int i = 0; i <= n; i++) next[i] = new ArrayList<>();

        int[] pre = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int[] order = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 1; j < order[0]; j++) {
                pre[order[j + 1]]++;

                next[order[j]].add(order[j + 1]);
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (pre[i] == 0) q.add(i);
        }

        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            int now = q.poll();

            ans.add(now);

            for (int to : next[now]) {
                pre[to]--;

                if (pre[to] == 0) q.add(to);
            }
        }

        if (ans.size() == n) {
            for (int a : ans) {
                System.out.println(a);
            }
        } else {
            System.out.println(0);
        }
    }
}
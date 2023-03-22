package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 문제집_1766 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        int[] questions = new int[n + 1];
        List<Integer>[] list = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int[] priority = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list[priority[0]].add(priority[1]);
            questions[priority[1]] += priority[0];
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 1; i < n + 1; i++) {
            if (questions[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int i = q.poll();
            System.out.print(i);

            for (int j : list[i]) {
                questions[j] -= i;

                if (questions[j] == 0) q.add(j);
            }

            if (!q.isEmpty()) System.out.print(" ");
        }
    }
}
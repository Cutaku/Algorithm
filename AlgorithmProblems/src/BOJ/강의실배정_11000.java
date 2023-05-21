package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 강의실배정_11000 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] classes = new int[n][];
        for (int i = 0; i < n; i++) classes[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(classes, (c1, c2) -> c1[0] == c2[0] ? c1[1] - c2[1] : c1[0] - c2[0]);

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int[] c : classes) {
            if (q.isEmpty()) {
                q.add(c[1]);
                continue;
            }

            if (q.peek() <= c[0]) {
                q.poll();
            }

            q.add(c[1]);
        }

        System.out.println(q.size());
    }
}
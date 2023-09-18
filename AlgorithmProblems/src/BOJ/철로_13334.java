package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 철로_13334 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] segments = new int[n][];
        for (int i = 0; i < n; i++) segments[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int d = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> start = new PriorityQueue<>();
        PriorityQueue<Integer> end = new PriorityQueue<>();

        for (int[] segment : segments) {
            int s = Math.min(segment[0], segment[1]);
            int e = Math.max(segment[0], segment[1]);

            if (e - s <= d) {
                start.add(e - d);
                end.add(s + 1);
            }
        }

        int count = 0;

        int max = 0;

        while (!start.isEmpty()) {
            if (start.peek() < end.peek()) {
                count++;
                start.poll();

                max = Math.max(max, count);
            } else if (start.peek() > end.peek()) {
                count--;
                end.poll();
            } else {
                start.poll();
                end.poll();
            }
        }

        System.out.println(max);
    }
}
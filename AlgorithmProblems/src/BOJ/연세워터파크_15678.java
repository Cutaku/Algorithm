package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 연세워터파크_15678 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nd = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nd[0], d = nd[1];

        int[] scores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Deque<Stone> deque = new ArrayDeque<>();

        long max = -1000000000;

        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && i - deque.peekFirst().i > d) deque.pollFirst();

            if (deque.isEmpty()) {
                max = Math.max(max, scores[i]);
                if (scores[i] >= 0) deque.add(new Stone(i, scores[i]));
            } else {
                long sum = deque.peekFirst().score + scores[i];
                max = Math.max(max, sum);

                while (!deque.isEmpty() && deque.peekLast().score <= sum) deque.pollLast();

                if (sum >= 0) deque.add(new Stone(i, sum));
            }
        }

        System.out.println(max);
    }

    static class Stone {
        int i;
        long score;

        public Stone(int i, long score) {
            this.i = i;
            this.score = score;
        }
    }
}
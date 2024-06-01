package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 콘센트_23843 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.comparingInt(a -> -a));
        PriorityQueue<Integer> min = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) max.add(Integer.parseInt(st.nextToken()));

        for (int i = 0; i < m; i++) min.add(0);

        while (!max.isEmpty()) {
            min.add(min.poll() + max.poll());
        }

        for (int i = 0; i < m - 1; i++) min.poll();

        System.out.println(min.poll());
    }
}
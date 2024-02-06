package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 달려라홍준_1306 {
    static int n;
    static int m;
    static int[] light;
    static Deque<Integer> dq;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = nm[0];
        m = nm[1];

        light = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dq = new ArrayDeque<>();

        for (int i = 0; i < 2 * m - 1; i++) {
            add(i);
        }

        sb.append(light[dq.peekFirst()]).append(" ");

        for (int i = 2 * m - 1; i < n; i++) {
            sb.append(add(i)).append(" ");
        }

        System.out.println(sb);
    }

    static int add(int i) {

        if (!dq.isEmpty() && i - dq.peekFirst() >= m * 2 - 1) dq.pollFirst();

        while (!dq.isEmpty() && light[dq.peekLast()] <= light[i]) dq.pollLast();
        dq.add(i);

        return light[dq.peekFirst()];
    }
}
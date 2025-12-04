package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Kaladėlės_30070 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[26];

        String input = br.readLine();

        for (int i = 0; i < n; i++) {
            char c = input.charAt(2 * i);

            if (++cnt[c - 'A'] > (n + 1) / 2) {
                System.out.println("NE");
                return;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a[1]));

        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) pq.add(new int[]{i, cnt[i]});
        }

        int[] last = new int[]{-1, 0};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int[] poll = pq.poll();

            sb.append((char) (poll[0] + 'A')).append(" ");
            poll[1]--;

            if (last[1] > 0) pq.add(last);

            last = poll;
        }

        System.out.println(sb);
    }
}
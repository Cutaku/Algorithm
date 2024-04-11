package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 문자열장식_1294 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int t = 0;

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
            t += words[i].length();
        }

        int[] idx = new int[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> {
            int l1 = words[i].length() - idx[i];
            int l2 = words[j].length() - idx[j];

           if (l1 == 0) return 1;
           if (l2 == 0) return -1;

           for (int k = 0; k < l1 + l2; k++) {
                char c1 = words[i].charAt(idx[i] + k % l1), c2 = words[j].charAt(idx[j] + k % l2);
                if (c1 != c2) return c1 - c2;
           }

            return 0;
        });

        for (int i = 0; i < n; i++) pq.add(i);

        for (int i = 0; i < t; i++) {
            int id = pq.poll();

            sb.append(words[id].charAt(idx[id]++));

            pq.add(id);
        }

        System.out.println(sb);
    }
}
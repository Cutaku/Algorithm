package BOJ;

import java.io.*;
import java.util.*;

public class 카드정렬_1715 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (n-- > 0) pq.add(Integer.parseInt(br.readLine()));

        int sum = 0;

        while (pq.size() > 1) {
            int s = pq.poll() + pq.poll();

            sum += s;
            pq.add(s);
        }

        System.out.println(sum);
    }
}
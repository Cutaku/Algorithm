package BOJ;

import java.io.*;
import java.util.*;

public class 모독_16678 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int c = 1;

        for (int i = 0; i < n; i++) {
            while (pq.peek() < c) {
                int m = pq.poll();
                while (m < c) m += k;
                pq.add(m);
            }

            if (pq.poll() > c++) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
    }
}
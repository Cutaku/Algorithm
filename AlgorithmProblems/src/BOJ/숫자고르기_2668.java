package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 숫자고르기_2668 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        boolean[] v = new boolean[n + 1];

        int sum = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            if (v[i]) continue;

            int p = i;

            int[] count = new int[n + 1];

            for (int j = 1; j <= n + 1; j++) {
                if (v[p]) {
                    if (count[p] > 0) {
                        sum += j - count[p];

                        int t = p;

                        do {
                            pq.add(t);
                            t = arr[t];
                        } while (t != p);
                    }

                    break;
                }

                v[p] = true;
                count[p] = j;

                p = arr[p];
            }
        }

        System.out.println(sum);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
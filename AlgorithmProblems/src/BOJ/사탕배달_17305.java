package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 사탕배달_17305 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> three = new PriorityQueue<>();
        PriorityQueue<Integer> five = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken());

            if (t == 3) three.add(-s);
            else five.add(-s);
        }

        int a = Math.min(w / 3, three.size());
        int b = Math.min(w / 5, five.size());

        long[] A = new long[a + 1];
        long[] B = new long[b + 1];

        for (int i = 0; i < a; i++) {
            A[i + 1] = A[i] - three.poll();
        }

        for (int i = 0; i < b; i++) {
            B[i + 1] = B[i] - five.poll();
        }

        long max = 0;

        for (int i = 0; i <= b; i++) {
            max = Math.max(max, B[i] + A[Math.min((w - 5 * i) / 3, a)]);
        }

        System.out.println(max);
    }
}
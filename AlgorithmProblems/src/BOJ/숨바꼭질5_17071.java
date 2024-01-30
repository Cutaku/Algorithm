package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 숨바꼭질5_17071 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0], k = nk[1];
        int max = 500000;

        List<Integer> K = new ArrayList<>();
        K.add(k);

        for (int i = 1; i <= 1000; i++) {
            k += i;
            if (k > max) break;
            K.add(k);
        }

        int[] oddMin = new int[max + 1];
        int[] evenMin = new int[max + 1];
        Arrays.fill(oddMin, 1000);
        Arrays.fill(evenMin, 1000);

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        q1.add(n);
        evenMin[n] = 0;

        int t = 0;
        boolean isOdd = false;

        int[] min;

        while (!q1.isEmpty()) {
            if (isOdd) min = evenMin;
            else min = oddMin;

            int now = q1.poll();

            if (now > 0 && min[now - 1] > t + 1) {
                min[now - 1] = t + 1;
                q2.add(now - 1);
            }

            if (now < max && min[now + 1] > t + 1) {
                min[now + 1] = t + 1;
                q2.add(now + 1);
            }

            if (2 * now <= max && min[2 * now] > t + 1) {
                min[2 * now] = t + 1;
                q2.add(2 * now);
            }

            if (q1.isEmpty()) {
                q1 = q2;
                q2 = new ArrayDeque<>();
                t++;
                isOdd = !isOdd;
            }
        }

        for (int i = 0; i < K.size(); i++) {
            if (i % 2 == 0 && evenMin[K.get(i)] <= i) {
                System.out.println(i);
                return;
            }

            if (i % 2 == 1 && oddMin[K.get(i)] <= i) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }
}
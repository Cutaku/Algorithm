package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 칵테일_1033 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n - 1; i++) {
            int[] r = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int d = gdc(r[2], r[3]);

            int[] ratio = new int[n];

            ratio[r[0]] = r[2] / d;
            ratio[r[1]] = r[3] / d;

            q.add(ratio);
        }

        int[] ans = q.poll();

        while (!q.isEmpty()) {
            int[] r = q.poll();

            int i = 0;

            while (i < n) {
                if (ans[i] * r[i] > 0) break;

                i++;
            }

            if (i == n) {
                q.add(r);

                continue;
            }

            int d = gdc(ans[i], r[i]);

            int a = r[i] / d;
            int b = ans[i] / d;

            for (int j = 0; j < n; j++) {
                ans[j] = Math.max(ans[j] * a, r[j] * b);
            }
        }

        for (int a : ans) {
            System.out.print(a + " ");
        }
    }

    public static int gdc(int a, int b) {

        while (b > 0) {
            int t = b;
            b = a % b;
            a = t;
        }

        return a;
    }
}
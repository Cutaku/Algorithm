package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 하이퍼토마토_17114 {
    static int[] size;
    static int s;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = new int[11];
        s = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 11; i++) {
            size[i] = Integer.parseInt(st.nextToken());
            s *= size[i];
        }

        boolean[] v = new boolean[s];
        int count = 0;

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        for (int i = 0; i < s / size[0]; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < size[0]; j++) {
                int a = Integer.parseInt(st.nextToken());
                int p = i * size[0] + j;

                if (a == 1) {
                    q1.add(p);
                    v[p] = true;
                    count++;
                } else if (a == -1) {
                    v[p] = true;
                    count++;
                }
            }
        }

        int time = -1;

        while (!q1.isEmpty()) {
            int p = q1.poll();
            int[] q = toArr(p);

            for (int i = 0; i < 11; i++) {
                q[i]++;
                int np = toInt(q);

                if (inRange(q) && !v[np]) {
                    v[np] = true;
                    count++;
                    q2.add(np);
                }

                q[i] -= 2;
                np = toInt(q);

                if (inRange(q) && !v[np]) {
                    v[np] = true;
                    count++;
                    q2.add(np);
                }

                q[i]++;
            }

            if (q1.isEmpty()) {
                Queue<Integer> temp = q1;
                q1 = q2;
                q2 = temp;
                time++;
            }
        }

        if (count == s) System.out.println(time);
        else System.out.println(-1);
    }

    static boolean inRange(int[] p) {

        for (int i = 0; i < 11; i++) {
            if (p[i] < 0 || p[i] >= size[i]) return false;
        }

        return true;
    }

    static int toInt(int[] p) {

        int d = 1;
        int res = 0;

        for (int i = 0; i < 11; i++) {
            res += p[i] * d;
            d *= size[i];
        }

        return res;
    }

    static int[] toArr(int p) {

        int[] res = new int[11];
        int d = 1;

        for (int i = 0; i < 11; i++) {
            res[i] = p % size[i];
            p /= size[i];
        }

        return res;
    }
}
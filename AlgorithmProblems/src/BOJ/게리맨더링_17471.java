package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 게리맨더링_17471 {
    static int n;
    static int[] populations;
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        populations = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        adj = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();

            int[] neighbor = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j <= neighbor[0]; j++) adj[i].add(neighbor[j]);
        }

        int min = 1000;

        boolean pos = false;

        for (int i = 1; i < Math.pow(2, n - 1); i++) {
            int j = (int) Math.pow(2, n) - i - 1;

            int a = isConnected(toArray(i));
            int b = isConnected(toArray(j));

            if (a > 0 && b > 0) {
                pos = true;

                if (a > b) min = Math.min(min, a - b);
                else min = Math.min(min, b - a);
            }
        }

        if (pos) System.out.println(min);
        else System.out.println(-1);
    }

    static boolean[] toArray(int m) {

        boolean[] result = new boolean[n];

        int i = 0;

        while (m > 0) {
            if (m % 2 == 1) result[i++] = true;
            else i++;

            m /= 2;
        }

        return result;
    }

    static int isConnected(boolean[] sector) {

        boolean[] v = new boolean[n];
        for (int i = 0; i < n; i++) v[i] = sector[i];

        Queue<Integer> q = new LinkedList<>();

        int s = 0;

        for (int i = 0; i < n; i++) {
            if (v[i]) {
                s = i + 1;
                break;
            }
        }

        q.add(s);
        v[s - 1] = false;

        int sum = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            sum += populations[now - 1];

            for (int next : adj[now]) {
                if (v[next - 1]) {
                    q.add(next);
                    v[next - 1] = false;
                }
            }
        }

        for (boolean b : v) {
            if (b) return 0;
        }

        return sum;
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 숨박꼭질3_13549 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0], k = nk[1];

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        boolean[] v = new boolean[100001];

        q.add(k);
        v[k] = true;

        int t = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            while (true) {
                if (now == n) {
                    System.out.println(t);
                    return;
                }
                
                if (now < 100000) {
                    set.add(now + 1);
                }

                if (now > 0) {
                    set.add(now - 1);
                }
                
                if (now % 2 == 1 || now == 0 || v[now / 2]) break;

                v[now / 2] = true;
                now /= 2;
            }

            if (q.isEmpty()) {
                for (int next : set) {
                    if (!v[next]) {
                        v[next] = true;
                        q.add(next);
                    }
                }
                set.clear();
                t++;
            }
        }
    }
}
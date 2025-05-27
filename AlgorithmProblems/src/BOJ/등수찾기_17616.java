package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 등수찾기_17616 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()) - 1;

        List<Integer>[] lower = new List[n];
        List<Integer>[] upper = new List[n];

        for (int i = 0; i < n; i++) {
            lower[i] = new ArrayList<>();
            upper[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            lower[b].add(a);
            upper[a].add(b);
        }

        boolean[] v = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();

        v[x] = true;
        q.add(x);

        int lCnt = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : lower[now]) {
                if (!v[next]) {
                    v[next] = true;
                    q.add(next);
                    lCnt++;
                }
            }
        }

        q.add(x);

        int uCnt = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : upper[now]) {
                if (!v[next]) {
                    v[next] = true;
                    q.add(next);
                    uCnt++;
                }
            }
        }

        System.out.print(lCnt + 1);
        System.out.print(" ");
        System.out.print(n - uCnt);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 학교탐방하기_13418 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[] root1 = new int[n + 1];
        int[] root2 = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            root1[i] = i;
            root2[i] = i;
        }

        PriorityQueue<int[]> q1 = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        PriorityQueue<int[]> q2 = new PriorityQueue<>(Comparator.comparingInt(a -> -a[2]));

        for (int i = 0; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = 1 - Integer.parseInt(st.nextToken());

            int[] road = new int[]{a, b, c};

            q1.add(road);
            q2.add(road);
        }

        System.out.println(findFatigue(root2, q2) - findFatigue(root1, q1));
    }

    static int findFatigue(int[] root, PriorityQueue<int[]> q) {

        int n = root.length;

        int res = 0;
        int count = 0;

        while (!q.isEmpty() && count < n - 1) {
            int[] road = q.poll();

            int a = find(road[0], root);
            int b = find(road[1], root);

            if (a == b) continue;

            root[Math.max(a, b)] = Math.min(a, b);

            count++;
            res += road[2];
        }

        return res * res;
    }

    static int find(int a, int[] root) {

        if (a == root[a]) return a;
        else return root[a] = find(root[a], root);
    }
}
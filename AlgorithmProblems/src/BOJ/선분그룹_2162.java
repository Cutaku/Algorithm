package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 선분그룹_2162 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] segments = new int[n][];
        for (int i = 0; i < n; i++) segments[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean[] used = new boolean[n];

        int group = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (used[i]) continue;

            group++;

            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            used[i] = true;

            int count = 0;

            while (!q.isEmpty()) {
                int now = q.poll();
                count++;

                for (int j = 0; j < n; j++) {
                    if (!used[j] && cross(segments[now], segments[j])) {
                        q.add(j);
                        used[j] = true;
                    }
                }
            }

            max = Math.max(max, count);
        }

        System.out.println(group);
        System.out.println(max);
    }

    public static boolean cross(int[] s1, int[] s2) {

        long x1 = s1[0], x2 = s1[2], x3 = s2[0], x4 = s2[2];
        long y1 = s1[1], y2 = s1[3], y3 = s2[1], y4 = s2[3];

        if (Math.max(x1, x2) < Math.min(x3, x4) || Math.max(x3, x4) < Math.min(x1, x2)) return false;
        if (Math.max(y1, y2) < Math.min(y3, y4) || Math.max(y3, y4) < Math.min(y1, y2)) return false;

        long l1 = (x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1);
        long l2 = (x2 - x1) * (y4 - y1) - (x4 - x1) * (y2 - y1);
        long l3 = (x4 - x3) * (y1 - y3) - (x1 - x3) * (y4 - y3);
        long l4 = (x4 - x3) * (y2 - y3) - (x2 - x3) * (y4 - y3);

        int v1 = l1 > 0 ? 1 : l1 < 0 ? - 1 : 0;
        int v2 = l2 > 0 ? 1 : l2 < 0 ? - 1 : 0;
        int v3 = l3 > 0 ? 1 : l3 < 0 ? - 1 : 0;
        int v4 = l4 > 0 ? 1 : l4 < 0 ? - 1 : 0;

        return !(v1 * v2 > 0 || v3 * v4 > 0);
    }
}
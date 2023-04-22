package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 선분교차2_17387 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] s1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] s2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(cross(s1, s2));
    }

    public static int cross(int[] s1, int[] s2) {

        long x1 = s1[0], x2 = s1[2], x3 = s2[0], x4 = s2[2];
        long y1 = s1[1], y2 = s1[3], y3 = s2[1], y4 = s2[3];

        if (Math.max(x1, x2) < Math.min(x3, x4) || Math.max(x3, x4) < Math.min(x1, x2)) return 0;
        if (Math.max(y1, y2) < Math.min(y3, y4) || Math.max(y3, y4) < Math.min(y1, y2)) return 0;

        long l1 = (x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1);
        long l2 = (x2 - x1) * (y4 - y1) - (x4 - x1) * (y2 - y1);
        long l3 = (x4 - x3) * (y1 - y3) - (x1 - x3) * (y4 - y3);
        long l4 = (x4 - x3) * (y2 - y3) - (x2 - x3) * (y4 - y3);

        int v1 = l1 > 0 ? 1 : l1 < 0 ? - 1 : 0;
        int v2 = l2 > 0 ? 1 : l2 < 0 ? - 1 : 0;
        int v3 = l3 > 0 ? 1 : l3 < 0 ? - 1 : 0;
        int v4 = l4 > 0 ? 1 : l4 < 0 ? - 1 : 0;

        if (v1 * v2 > 0 || v3 * v4 > 0) return 0;
        else return 1;
    }
}
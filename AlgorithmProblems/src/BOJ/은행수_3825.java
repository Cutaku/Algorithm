package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 은행수_3825 {
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        init();

        boolean[][] isNotPrime = new boolean[301][301];

        for (int i = 0; i < list.size(); i++) {
            int[] a = list.get(i);

            if (isNotPrime[a[0] + 150][a[1] + 150]) continue;

            for (int j = i; j < list.size(); j++) {
                int[] b = list.get(j);

                if (a[2] * b[2] >= 20000) break;

                int x = a[0] * b[0] - a[1] * b[1];
                int y = a[0] * b[1] + a[1] * b[0];

                isNotPrime[x + 150][y + 150] = true;
                isNotPrime[y + 150][x + 150] = true;
                isNotPrime[-x + 150][y + 150] = true;
                isNotPrime[-y + 150][x + 150] = true;
                isNotPrime[x + 150][-y + 150] = true;
                isNotPrime[y + 150][-x + 150] = true;
                isNotPrime[-x + 150][-y + 150] = true;
                isNotPrime[-y + 150][-x + 150] = true;
            }
        }

        for (int t = 0; t < T; t++) {
            int[] q = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (isNotPrime[q[0] + 150][q[1] + 150]) System.out.println("C");
            else System.out.println("P");
        }
    }

    static void init() {

        for (int i = -150; i <= 150; i++) {
            for (int j = -150; j <= 150; j++) {
                if (isOut(i, j)) continue;

                list.add(new int[] {i, j, i * i + j * j});
            }
        }

        list.sort(Comparator.comparingInt(a -> a[2]));
    }

    public static boolean isOut(int a, int b) {

        return !(a * a + b * b > 1 && a * a + b * b < 20000);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 비숍_1799 {
    static int n;
    static List<int[]> list1;
    static List<int[]> list2;
    static int max1;
    static int max2;
    static boolean[] cross1;
    static boolean[] cross2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][];
        for (int i = 0; i < n; i++) board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        list1 = new ArrayList<>();
        list2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    if ((i + j) % 2 == 0) list1.add(new int[]{i, j});
                    if ((i + j) % 2 == 1) list2.add(new int[]{i, j});
                }
            }
        }

        max1 = 0;
        max2 = 0;

        cross1 = new boolean[2 * n - 1];
        cross2 = new boolean[2 * n - 1];

        dfs(list1, 0, 0, true);
        dfs(list2, 0, 0, false);

        System.out.println(max1 + max2);
    }

    public static void dfs(List<int[]> list, int d, int count, boolean isEven) {

        if (d == list.size()) {
            if (isEven) max1 = Math.max(max1, count);
            else max2 = Math.max(max2, count);
            return;
        }

        int[] point = list.get(d);
        int x = point[0];
        int y = point[1];

        if (!cross1[x + y] && !cross2[n - 1 + x - y]) {
            cross1[x + y] = true;
            cross2[n - 1 + x - y] = true;

            dfs(list, d + 1, count + 1, isEven);

            cross1[x + y] = false;
            cross2[n - 1 + x - y] = false;
        }

        dfs(list, d + 1, count, isEven);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 색종이붙이기_17136 {
    static int[][] paper;
    static int[] left;
    static int count;
    static int min;
    static boolean pos;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        paper = new int[10][];
        for (int i = 0; i < 10; i++) {
            paper[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        left = new int[]{5, 5, 5, 5, 5};
        count = 0;
        min = 25;
        pos = false;

        dfs();

        if (pos) System.out.println(min);
        else System.out.println(-1);
    }

    public static void dfs() {

        int[] one = findOne();

        if (one == null) {
            pos = true;
            min = Math.min(min, count);
            return;
        }

        int x = one[0], y = one[1];

        for (int i = 5; i > 0 ; i--) {
            if (!cover(x, y, i) || left[i - 1] == 0) continue;

            left[i - 1]--;
            change(x, y, i, 0);
            count++;

            dfs();

            left[i - 1]++;
            change(x, y, i, 1);
            count--;
        }
    }

    public static int[] findOne() {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (paper[i][j] == 1) return new int[]{i, j};
            }
        }

        return null;
    }

    public static boolean cover(int x, int y, int size) {

        if (x + size > 10 || y + size > 10) return false;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (paper[x + i][y + j] == 0) return false;
            }
        }

        return true;
    }

    public static void change(int x, int y, int size, int to) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                paper[x + i][y + j] = to;
            }
        }
    }
}
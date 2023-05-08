package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 캐슬디펜스_17135 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nmd = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nmd[0], m = nmd[1], d = nmd[2];

        int[][] field = new int[n][];
        for (int i = 0; i < n; i++) field[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int max = 0;

        for (int i = 7; i < Math.pow(2, m); i++) {
            boolean[] archers = toArray(m, i);

            if (count(archers) != 3) continue;

            int[][] f = copy(field);

            int count = 0;

            for (int j = 0; j < n; j++) {
                count += attack(archers, f, d);
                move(f);
            }

            max = Math.max(max, count);
        }

        System.out.println(max);
    }

    static int[][] copy(int[][] field) {

        int n = field.length;
        int m = field[0].length;

        int[][] result = new int[n][];
        for (int i = 0; i < n; i++) result[i] = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = field[i][j];
            }
        }

        return result;
    }

    static boolean[] toArray(int n, int m) {

        boolean[] result = new boolean[n];

        int i = 0;

        while (m > 0) {
            if (m % 2 == 1) result[i++] = true;
            else i++;

            m /= 2;
        }

        return result;
    }

    static int count(boolean[] archers) {

        int count = 0;

        for (boolean archer : archers) {
            if (archer) count++;
        }

        return count;
    }

    static int attack(boolean[] archers, int[][] field, int d) {

        int n = field.length;
        int m = field[0].length;

        List<int[]> targets = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            if (!archers[i]) continue;

            int[] target = new int[]{0, 0};
            boolean flag = false;
            int min = d + 1;

            for (int j = 0; j < m; j++) {
                for (int k = n - 1; k >= 0; k--) {
                    if (field[k][j] == 0) continue;

                    int distance = n - k + Math.abs(i - j);

                    if (distance < min) {
                        target = new int[]{k, j};
                        min = distance;
                        flag = true;
                    }

                    break;
                }
            }

            if (flag) targets.add(target);
        }

        int count = 0;

        for (int[] target : targets) {
            if (field[target[0]][target[1]] == 1) {
                count++;
                field[target[0]][target[1]] = 0;
            }
        }

        return count;
    }

    static void move(int[][] field) {

        int n = field.length;
        int m = field[0].length;

        for (int i = n - 1; i > 0; i--) field[i] = field[i - 1];
        field[0] = new int[m];
    }
}
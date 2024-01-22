package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 빙고_2578 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[26][];

        for (int i = 0; i < 5; i++) {
            int[] p = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < 5; j++) {
                board[p[j]] = new int[]{i, j};
            }
        }

        int[] row = new int[5];
        int[] col = new int[5];
        int d1 = 0;
        int d2 = 0;

        int bingo = 0;

        for (int i = 0; i < 5; i++) {
            int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < 5; j++) {
                int x = board[num[j]][0];
                int y = board[num[j]][1];

                if (++row[x] == 5) bingo++;
                if (++col[y] == 5) bingo++;

                if (x == y) {
                    if (++d1 == 5) bingo++;
                }

                if (x + y == 4) {
                    if (++d2 == 5) bingo++;
                }

                if (bingo >= 3) {
                    System.out.println(5 * i + j + 1);
                    return;
                }
            }
        }
    }
}
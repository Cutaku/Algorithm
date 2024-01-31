package SWExpertAcademy;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Ladder1_1210 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = 10;

        while (T-- > 0) {
            bw.append(String.format("#%d ", Integer.parseInt(br.readLine())));

            int[][] maze = new int[100][];
            for (int i = 0; i < 100; i++) {
                maze[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            List<Integer> lines = new ArrayList<>();


            for (int i = 0; i < 100; i++) {
                if (maze[99][i] > 0) {
                    lines.add(i);
                }
            }

            int g = 0;
            int l = lines.size();

            for (int i = 0; i < l; i++) {
                if (maze[99][lines.get(i)] == 2) {
                    g = i;
                }
            }

            int[] change = new int[l];
            for (int i = 0; i < l; i++) change[i] = i;

            for (int i = 1; i < 99; i++) {
                for (int j = 0; j < l - 1; j++) {
                    if (maze[i][lines.get(j) + 1] > 0) {
                        int t = change[j];
                        change[j] = change[j + 1];
                        change[j + 1] = t;
                    }
                }
            }

            bw.append(String.format("%d\n", lines.get(change[g])));
        }

        bw.flush();
    }
}
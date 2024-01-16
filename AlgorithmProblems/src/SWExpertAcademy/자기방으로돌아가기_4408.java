package SWExpertAcademy;

import java.io.*;
import java.util.Arrays;

public class 자기방으로돌아가기_4408 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            bw.append("#").append(String.valueOf(tc)).append(" ");

            int n = Integer.parseInt(br.readLine());

            int[][] moves = new int[n][];
            for (int i = 0; i < n; i++) {
                int[] move = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                if (move[0] > move[1]) {
                    int t = move[0];
                    move[0] = move[1];
                    move[1] = t;
                }

                move[0] = (move[0] + 1) / 2;
                move[1] = (move[1] + 1) / 2;

                moves[i] = move;
            }

            Arrays.sort(moves, (m1, m2) -> {
                if (m1[0] == m2[0]) return m1[1] - m2[1];
                else return m1[0] - m2[0];
            });

            int[] last = new int[n];
            int c = 1;

            for (int[] move : moves) {
                boolean b = true;

                for (int i = 0; i < c; i++) {
                    if (last[i] < move[0]) {
                        last[i] = move[1];
                        b = false;
                        break;
                    }
                }

                if (b) last[c++] = move[1];
            }

            bw.append(String.valueOf(c)).append("\n");
        }

        bw.flush();
    }
}
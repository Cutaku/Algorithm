package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 미친아두이노_8972 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] rc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = rc[0], c = rc[1];

        char[][] board = new char[r][];
        for (int i = 0; i < r; i++) board[i] = br.readLine().toCharArray();

        int[] js = new int[2];

        Map<Integer, int[]> map = new HashMap<>();
        map.put(1, new int[]{1, -1});
        map.put(2, new int[]{1, 0});
        map.put(3, new int[]{1, 1});
        map.put(4, new int[]{0, -1});
        map.put(5, new int[]{0, 0});
        map.put(6, new int[]{0, 1});
        map.put(7, new int[]{-1, -1});
        map.put(8, new int[]{-1, 0});
        map.put(9, new int[]{-1, 1});

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'I') {
                    js[0] = i;
                    js[1] = j;
                }
            }
        }

        int[] moves = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        int m = moves.length;

        for (int t = 1; t <= m; t++) {
            int[] move = map.get(moves[t - 1]);

            js[0] += move[0];
            js[1] += move[1];

            if (board[js[0]][js[1]] == 'R') {
                System.out.println("kraj " + t);
                return;
            }

            char[][] temp = new char[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    temp[i][j] = '.';
                }
            }

            temp[js[0]][js[1]] = 'I';

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (board[i][j] != 'R') continue;

                    int x = i, y = j;

                    if (x < js[0]) x++;
                    else if (x > js[0]) x--;

                    if (y < js[1]) y++;
                    else if (y > js[1]) y--;

                    if (temp[x][y] == 'I') {
                        System.out.println("kraj " + t);
                        return;
                    } else if (temp[x][y] == 'R') {
                        temp[x][y] = 'B';
                    } else if (temp[x][y] == '.') {
                        temp[x][y] = 'R';
                    }
                }
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (temp[i][j] == 'B') temp[i][j] = '.';
                }
            }

            board = temp;
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                bw.append(board[i][j]);
            }

            bw.append("\n");
        }

        bw.flush();
    }
}
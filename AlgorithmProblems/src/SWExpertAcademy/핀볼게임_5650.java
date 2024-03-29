package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 핀볼게임_5650 {
    static int n, max;
    static int[][] board = new int[100][100];
    static Map<Integer, Integer> warmHole;
    static int[][] D = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] changeDir = {{}, {2, 3, 1, 0}, {1, 3, 0, 2}, {3, 2, 0, 1}, {2, 0, 3, 1}, {2, 3, 0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            sb.append('#').append(tc).append(' ');

            n = Integer.parseInt(br.readLine().trim());

            warmHole = new HashMap<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine().trim());

                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());

                    if (board[i][j] > 5) {
                        int wh = i * 100 + j;

                        if (!warmHole.containsKey(-board[i][j])) {
                            warmHole.put(-board[i][j], wh);
                        } else {
                            int another = warmHole.get(-board[i][j]);
                            warmHole.put(wh, another);
                            warmHole.put(another, wh);
                        }
                    }
                }
            }

            max = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != 0) continue;

                    for (int d = 0; d < 4; d++) {
                        max = Math.max(max, findScore(i, j, d));
                    }
                }
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }

    static int findScore(int i, int j, int dir) {

        int score = 0;

        int si = i, sj = j;

        i += D[dir][0];
        j += D[dir][1];

        while (i != si || j != sj) {

            if (i < 0 || j < 0 || i >= n || j >= n) {
                score++;

                dir = changeDir[5][dir];
            } else if (board[i][j] > 5) {
                int w = warmHole.get(i * 100 + j);
                i = w / 100;
                j = w % 100;
            } else if (board[i][j] > 0) {
                score++;

                dir = changeDir[board[i][j]][dir];

            } else if (board[i][j] < 0) {
                break;
            }

            i += D[dir][0];
            j += D[dir][1];
        }

        return score;
    }
}
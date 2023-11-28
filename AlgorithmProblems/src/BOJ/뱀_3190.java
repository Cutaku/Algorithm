package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 뱀_3190 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];
        board[0][0] = 1;

        for (int i = 0; i < k; i++) {
            int[] apple = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            board[apple[0] - 1][apple[1] - 1] = 2;
        }

        Map<String, int[]> D = new HashMap<>();
        D.put("D", new int[]{1, -1});
        D.put("L", new int[]{-1, 1});

        Queue<int[]> snake = new LinkedList<>();
        snake.add(new int[]{0, 0});

        int l = Integer.parseInt(br.readLine());

        String[][] direction = new String[l][];
        for (int i = 0; i < l; i++) {
            direction[i] = br.readLine().split(" ");
        }

        int t = 0;

        int[] d = new int[]{0, 1};

        int[] head = new int[]{0, 0};

        for (int i = 0; i <= l; i++) {
            while (true) {
                t++;

                head[0] += d[0];
                head[1] += d[1];

                if (head[0] < 0 || head[1] < 0 || head[0] >= n || head[1] >= n || board[head[0]][head[1]] == 1) {
                    System.out.println(t);
                    return;
                }

                snake.add(new int[]{head[0], head[1]});

                if (board[head[0]][head[1]] == 0) {
                    int[] tail = snake.poll();
                    board[tail[0]][tail[1]] = 0;
                }

                board[head[0]][head[1]] = 1;

                if (i < l && t == Integer.parseInt(direction[i][0])) break;
            }

            int temp = d[0];
            d[0] = d[1] * D.get(direction[i][1])[0];
            d[1] = temp * D.get(direction[i][1])[1];
        }
    }
}
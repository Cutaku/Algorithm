package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 꼬리잡기놀이 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nums[0], m = nums[1], k = nums[2];

        int[][] board = new int[n][];
        for (int i = 0; i < n; i++) board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Cycle> list = new ArrayList<>();

        int[][] D = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        boolean[][] visited = new boolean[n][];
        for (int i = 0; i < n; i++) visited[i] = new boolean[n];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] != 1) continue;

                visited[i][j] = true;

                Cycle c = new Cycle();
                list.add(c);

                c.dq.add(new int[] {i, j});
                q.add(new int[] {i, j});

                while (!q.isEmpty()) {

                    int[] now = q.poll();

                    if (board[now[0]][now[1]] == 2 || board[now[0]][now[1]] == 3) c.num++;

                    for (int[] d : D) {
                        int x = now[0] + d[0];
                        int y = now[1] + d[1];

                        if (x < 0 || y < 0 || x >= n || y >= n || visited[x][y]) continue;

                        if (board[x][y] >= board[now[0]][now[1]] && board[x][y] - board[now[0]][now[1]] <= 1) {
                            visited[x][y] = true;
                            q.add(new int[] {x, y});
                            c.dq.add(new int[] {x, y});
                        }
                    }
                }
            }
        }

        int score = 0;

        for (int i = 0; i < k; i++) {
            nextRound(list);
            score += getScore(list, i, n);
        }

        System.out.println(score);
    }

    public static void nextRound(List<Cycle> list) {

        for (Cycle c : list) {
            c.nextRound();
        }
    }

    public static int getScore(List<Cycle> list, int round, int n) {

        round %= 4 * n;

        int dir = round / n;
        int m = round % n;

        int[] cycleNum = new int[n];
        int[] scores = new int[n];

        for (int i = 0; i < list.size(); i++) {
            Cycle c = list.get(i);
            List<int[]> temp = (List<int[]>) c.dq;

            for (int j = 0; j < c.num; j++) {
                int[] point = temp.get(j);

                int x = 0, y = 0;

                switch (dir) {
                    case 0:
                        x = point[0];
                        y = point[1];
                        break;
                    case 1:
                        x = point[1];
                        y = n - 1 - point[0];
                        break;
                    case 2:
                        x = n - 1 - point[0];
                        y = n - 1 - point[1];
                        break;
                    case 3:
                        x = n - 1 - point[1];
                        y = point[0];
                        break;
                }

                if (x == m) {
                    cycleNum[y] = i;
                    scores[y] = (c.dir) ? (j + 1) * (j + 1) : (c.num - j) * (c.num - j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (scores[i] > 0) {
                if (list.get(cycleNum[i]).dir) list.get(cycleNum[i]).dir = false;
                else list.get(cycleNum[i]).dir = true;
                return scores[i];
            }
        }

        return 0;
    }

    public static class Cycle {

        Deque<int[]> dq = new LinkedList<>();
        int num = 1;
        boolean dir = true;

        void nextRound() {

            if (dir) {
                dq.addFirst(dq.pollLast());
            } else {
                dq.addLast(dq.pollFirst());
            }
        }

        int getScore(int x, int y) {
            for (int i = 0; i < num; i++) {
                List<int[]> temp = (List<int[]>) dq;

                if (temp.get(i)[0] == x && temp.get(i)[1] == y) {
                    if (dir) return (i + 1) * (i + 1);
                    else return (num - i) * (num - i);
                }
            }

            return 0;
        }
    }
}
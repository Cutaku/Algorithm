import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 탈출_3055 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] rc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = rc[0];
        int c = rc[1];

        char[][] map = new char[r][];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        Queue<int[]> q3 = new LinkedList<>();
        Queue<int[]> q4 = new LinkedList<>();

        int[] goal = {0, 0};
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'S') {
                    q1.add(new int[] {i, j});
                } else if (map[i][j] == 'D') {
                    goal = new int[] {i,j};
                } else if (map[i][j] == '*') {
                    q3.add(new int[] {i, j});
                }
            }
        }

        int[][] D = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int count = 0;

        do {
            while (!q3.isEmpty()) {
                int[] now = q3.poll();

                for (int[] d : D) {
                    int i = now[0] + d[0];
                    int j = now[1] + d[1];
                    int[] temp = {i, j};

                    if (i >= 0 && j >= 0 && i < r && j < c && (map[i][j] == '.' || map[i][j] == 'S')) {
                        q4.add(temp);
                        map[i][j] = '*';
                    }
                }
            }

            while (!q1.isEmpty()) {
                int[] now = q1.poll();

                for (int[] d : D) {
                    int i = now[0] + d[0];
                    int j = now[1] + d[1];
                    int[] temp = {i, j};

                    if (i == goal[0] && j == goal[1]) {
                        System.out.println(count+1);
                        return;
                    }

                    if (i >= 0 && j >= 0 && i < r && j < c && (map[i][j] == '.' || map[i][j] == 'D')) {
                        q2.add(temp);
                        map[i][j] = 'S';
                    }
                }
            }

            q1 = q2;
            q3 = q4;
            q2 = new LinkedList<>();
            q4 = new LinkedList<>();
            count++;
        } while (!q1.isEmpty());

        System.out.println("KAKTUS");
    }
}
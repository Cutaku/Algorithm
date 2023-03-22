import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 도넛행성_코테2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];

        int[][] donut = new int[n][];

        for (int i = 0; i < n; i++) {
            donut[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] D = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int count = 0;

        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (donut[i][j] == 0) {
                    count++;

                    q1.add(new int[]{i, j});
                    donut[i][j] = 1;

                    while (!q1.isEmpty()) {
                        int[] now = q1.poll();

                        for (int[] d : D) {
                            int x = (now[0] + d[0] + n)%n;
                            int y = (now[1] + d[1] + m)%m;

                            if (donut[x][y] == 0) {
                                q2.add(new int[]{x, y});
                                donut[x][y] = 1;
                            }
                        }

                        if (q1.isEmpty()) {
                            q1 = q2;
                            q2 = new LinkedList<>();
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}
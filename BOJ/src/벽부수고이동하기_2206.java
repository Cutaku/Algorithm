import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 벽부수고이동하기_2206 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];

        int[][] map = new int[n][];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        Queue<int[]> q3 = new LinkedList<>();
        Queue<int[]> q4 = new LinkedList<>();

        int[][] check = new int[n][];
        for (int i = 0; i < n; i++) {
            check[i] = new int[m];
        }

        q1.add(new int[] {0, 0});
        check[0][0] = 2;

        int[][] D = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int count = 1;

        while (!q1.isEmpty() || !q3.isEmpty()) {

            if (!q1.isEmpty()) {
                int[] a = q1.poll();

                if (a[0] == n-1 && a[1] == m-1) {
                    System.out.println(count);
                    return;
                }

                for (int[] d : D) {
                    int i = a[0] + d[0];
                    int j = a[1] + d[1];
                    int[] temp = {i, j};

                    if (i >= 0 && j >= 0 && i < n && j < m) {
                        if (map[i][j] == 0 && check[i][j] < 2) {
                            q2.add(temp);
                            check[i][j] = 2;
                        } else if (map[i][j] == 1 && check[i][j] == 0) {
                            q4.add(temp);
                            check[i][j] = 1;
                        }
                    }
                }
            }

            if (!q3.isEmpty()) {
                int[] b = q3.poll();

                if (b[0] == n-1 && b[1] == m-1) {
                    System.out.println(count);
                    return;
                }

                for (int[] d : D) {
                    int i = b[0] + d[0];
                    int j = b[1] + d[1];
                    int[] temp = {i, j};

                    if (i >= 0 && j >= 0 && i < n && j < m && map[i][j] == 0 && check[i][j] == 0) {
                        q4.add(temp);
                        check[i][j] = 1;
                    }
                }
            }

            if (q1.isEmpty() && q3.isEmpty()) {
                q1 = q2;
                q3 = q4;
                q2 = new LinkedList<>();
                q4 = new LinkedList<>();
                count++;
            }
        }

        System.out.println(-1);
    }
}
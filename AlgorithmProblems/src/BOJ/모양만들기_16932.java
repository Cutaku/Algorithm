package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 모양만들기_16932 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        List<int[]> zero = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                if ((map[i][j] = Integer.parseInt(st.nextToken())) == 0) zero.add(new int[]{i, j});
            }
        }

        int num = 2;

        List<Integer> cnt = new ArrayList<>();
        cnt.add(0);
        cnt.add(0);


        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 1) continue;

                List<int[]> q = new ArrayList<>();

                q.add(new int[]{i, j});
                map[i][j] = num;
                int idx = 0;

                while (idx < q.size()) {
                    int[] now = q.get(idx++);

                    for (int[] d : D) {
                        int r = now[0] + d[0];
                        int c = now[1] + d[1];

                        if (r < 0 || c < 0 || r >= n || c >= m || map[r][c] != 1) continue;

                        q.add(new int[]{r, c});
                        map[r][c] = num;
                    }
                }

                cnt.add(q.size());
                num++;
            }
        }

        int max = 0;

        for (int[] z : zero) {
            Set<Integer> set = new HashSet<>();

            for (int[] d : D) {
                int r = z[0] + d[0];
                int c = z[1] + d[1];

                if (r < 0 || c < 0 ||  r >= n || c >= m) continue;

                set.add(map[r][c]);
            }

            int sum = 1;
            for (int idx : set) sum += cnt.get(idx);

            max = Math.max(max, sum);
        }

        System.out.println(max == 0 ? n * m : max);
    }
}
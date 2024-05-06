package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 컨닝2_11014 {
    static char[][] classroom = new char[80][80];
    static boolean[] v;
    static List<Integer> evenCol;
    static List<Integer>[] next;
    static int[] before;
    static int[][] D = {{-1, -1}, {0, -1}, {1, -1}, {-1, 1}, {0, 1}, {1, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int c = Integer.parseInt(br.readLine());

        while (c-- > 0) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int total = 0;

            for (int i = 0; i < n; i++) {
                String line = br.readLine();

                for (int j = 0; j < m; j++) {
                    classroom[i][j] = line.charAt(j);
                    if (classroom[i][j] == '.') total++;
                }
            }

            evenCol = new ArrayList<>();
            next = new List[6400];
            before = new int[6400];

            Arrays.fill(before, -1);

            for (int j = 0; j < m; j += 2) {
                for (int i = 0; i < n; i++) {
                    if (classroom[i][j] != '.') continue;

                    int p = i * 80 + j;

                    evenCol.add(p);

                    next[p] = new ArrayList();

                    for (int[] d : D) {
                        int x = i + d[0], y = j + d[1];

                        if (x < 0 || y < 0 || x >= n || y >= m || classroom[x][y] == 'x') continue;

                        next[p].add(x * 80 + y);
                    }
                }
            }

            sb.append(total - countMatching()).append("\n");
        }

        System.out.println(sb);
    }

    static int countMatching() {

        int ans = 0;

        for (int i = 0; i < evenCol.size(); i++) {
            v = new boolean[6400];

            if (dfs(evenCol.get(i))) ans++;
        }

        return ans;
    }

    static boolean dfs(int even) {
        for (int odd : next[even]) {
            if (v[odd]) continue;
            v[odd] = true;

            if (before[odd] < 0 || dfs(before[odd])) {
                before[odd] = even;
                return true;
            }
        }

        return false;
    }
}
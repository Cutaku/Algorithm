package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 가장높은탑쌓기_2655 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] blocks = new int[n][4];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            blocks[i][0] = i;

            for (int j = 1; j < 4; j++) {
                blocks[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(blocks, Comparator.comparingInt(a -> -a[3]));

        TreeSet<int[]> set = new TreeSet<>((a, b) ->  {
            if (a[2] == b[2]) return a[0] - b[0];
            return b[2] - a[2];
        });

        int[] before = new int[n];

        set.add(new int[]{-1, 10001, 0, 0});

        for (int i = 0; i < n; i++) {
            for (int[] top : set) {
                if (top[1] > blocks[i][1]) {
                    set.add(new int[]{blocks[i][0], blocks[i][1], top[2] + blocks[i][2], top[3] + 1});

                    before[blocks[i][0]] = top[0];
                    break;
                }
            }
        }

        int[] last = set.first();
        sb.append(last[3]).append("\n");

        int idx = last[0];


        while (idx >= 0) {
            sb.append(idx + 1).append("\n");
            idx = before[idx];
        }

        System.out.println(sb);
    }
}
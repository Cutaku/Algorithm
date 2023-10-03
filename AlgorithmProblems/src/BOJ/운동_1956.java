package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 운동_1956 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 4000001;

        int[] ve = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int v = ve[0], e = ve[1];

        int[][] minDistance = new int[v + 1][v + 1];
        for (int i = 0; i <= v; i++) Arrays.fill(minDistance[i], max);

        for (int i = 0; i < e; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            minDistance[edge[0]][edge[1]] = edge[2];
        }

        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i == j) continue;

                for (int k = j; k <= v; k++) {
                    if (i == k) continue;

                    minDistance[j][k] = Math.min(minDistance[j][k], minDistance[j][i] + minDistance[i][k]);
                }
            }
        }

        int min = max;

        for (int i = 1; i <= v; i++) {
            min = Math.min(min, minDistance[i][i]);
        }

        if (min < max) System.out.println(min);
        else System.out.println(-1);
    }
}
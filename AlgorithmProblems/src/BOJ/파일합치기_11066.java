package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 파일합치기_11066 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());

            int[] pages = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[][] costs = new int[k][k];
            int[][] sums = new int[k][k];

            for (int i = 0; i < k; i++) sums[i][i] = pages[i];

            for (int i = 0; i < k - 1; i++) {
                for (int j = i + 1; j < k; j++) {
                    sums[i][j] = sums[i][j - 1] + pages[j];
                }
            }

            for (int d = 1; d < k; d++) {
                for (int i = 0; i + d < k; i++) {
                    costs[i][i + d] = sums[i][i + d];

                    int cost = costs[i + 1][i + d];

                    for (int j = 1; j < d; j++) {
                        cost = Math.min(cost, costs[i][i + j] + costs[i + j + 1][i + d]);
                    }

                    costs[i][i + d] += cost;
                }
            }

            System.out.println(costs[0][k - 1]);
        }
    }
}
package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 나무박멸 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nums[0];
        int m = nums[1];
        int k = nums[2];
        int c = nums[3];

        int[][] trees = new int[n][];
        for (int i = 0; i < n; i++) trees[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int count = 0;

        for (int i = 0; i < m; i++) {
            grow(trees);
            count += useHerbicide(trees, k, c);
        }

        System.out.println(count);
    }

    static public void grow(int[][] trees) {

        int n = trees.length;

        int[][] D = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int[][] newTrees = new int[n][];
        for (int i = 0; i < n; i++) newTrees[i] = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;

                if (trees[i][j] <= 0) continue;

                for (int[] d : D) {
                    int x = i + d[0];
                    int y = j + d[1];

                    if (x >= 0 && y >= 0 && x < n && y < n) {
                        if (trees[x][y] > 0) trees[i][j]++;
                        else if (trees[x][y] == 0) count++;
                    }
                }

                for (int [] d : D) {
                    int x = i + d[0];
                    int y = j + d[1];

                    if (x >= 0 && y >= 0 && x < n && y < n) {
                        if (trees[x][y] == 0) newTrees[x][y] += trees[i][j] / count;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                trees[i][j] += newTrees[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (trees[i][j] < -1) {
                    trees[i][j]++;
                    if (trees[i][j] == -1) trees[i][j]++;
                }
            }
        }
    }

    static int useHerbicide(int[][] trees, int k, int c) {

        int n = trees.length;

        int max = 0;
        int[] maxInd = new int[] {0, 0};

        int[][] D = new int[][] {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = trees[i][j];

                if (count <= 0) continue;

                for (int[] d : D) {
                    int x = i;
                    int y = j ;

                    for (int l = 0; l < k ; l++) {
                        x += d[0];
                        y += d[1];

                        if (x < 0 || y < 0 || x >= n || y >= n ) break;

                        if (trees[x][y] > 0) count += trees[x][y];
                        else break;
                    }
                }

                if (count > max) {
                    max = count;
                    maxInd = new int[] {i, j};
                }
            }
        }

        for (int[] d : D) {
            int x = maxInd[0];
            int y = maxInd[1];

            trees[x][y] = 0 - c - 1;

            for (int i = 0; i < k; i++) {
                x += d[0];
                y += d[1];

                if (x < 0 || y < 0 || x >= n || y >= n ) break;

                if (trees[x][y] > 0) {
                    trees[x][y] = 0 - c - 1;
                } else if (trees[x][y] != -1) {
                    trees[x][y] = 0 - c - 1;
                    break;
                } else {
                    break;
                }
            }
        }

        return max;
    }
}
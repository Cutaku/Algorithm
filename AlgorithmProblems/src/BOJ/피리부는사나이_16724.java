package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 피리부는사나이_16724 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        Map<Character, int[]> map = new HashMap<>();
        map.put('D', new int[]{1, 0});
        map.put('R', new int[]{0, 1});
        map.put('U', new int[]{-1, 0});
        map.put('L', new int[]{0, -1});

        char[][] board = new char[n][];
        for (int i = 0; i < n; i++) board[i] = br.readLine().toCharArray();

        int[][] visited = new int[n][];
        for (int i = 0; i < n; i++) visited[i] = new int[m];

        int count = 0;
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0) {

                    int x = i;
                    int y = j;

                    while (visited[x][y] == 0) {
                        visited[x][y] = num;

                        int[] move = map.get(board[x][y]);

                        x += move[0];
                        y += move[1];
                    }

                    if (visited[x][y] == num) count++;

                    num++;
                }
            }
        }

        System.out.println(count);
    }
}
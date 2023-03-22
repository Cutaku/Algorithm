import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 열쇠_9328 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            int[] hw = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int h = hw[0];
            int w = hw[1];


            char[][] map = new char[h][];
            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().toCharArray();
            }

            List<Character> keys = new ArrayList<>();
            char[] firstKeys = br.readLine().toUpperCase().toCharArray();
            for (char key : firstKeys) keys.add((Character) key);


            Queue<int[]> q1 = new LinkedList<>();
            Queue<int[]> q2 = new LinkedList<>();
            Queue<int[]> q3 = new LinkedList<>();

            int count = 0;

            for (int i = 0; i < h; i++) {
                q1.add(new int[] {i, -1});
                q1.add(new int[] {i, w});
            }
            for (int i = 1; i < w-1; i++) {
                q1.add(new int[] {-1, i});
                q1.add(new int[] {h, i});
            }

            int[][] D = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

            while (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    int[] now = q1.poll();

                    for (int[] d : D) {
                        int i = now[0] + d[0];
                        int j = now[1] + d[1];
                        int[] temp = {i, j};

                        if (i >= 0 && j >= 0 && i < h && j < w) {

                            if (map[i][j] == '.') {
                                q1.add(temp);
                                map[i][j] = '*';
                            } else if (map[i][j] == '$') {
                                q1.add(temp);
                                map[i][j] = '*';
                                count++;
                            } else if (map[i][j] >= 'a' && map[i][j] <= 'z') {
                                q1.add(temp);
                                char c = map[i][j];
                                c -= 32;
                                keys.add(c);
                                map[i][j] = '*';
                            } else if (map[i][j] >= 'A' && map[i][j] <= 'Z'){
                                q2.add(temp);
                            }
                        }
                    }
                }

                while (!q2.isEmpty()) {
                    int[] gate = q2.poll();

                    if (keys.contains(map[gate[0]][gate[1]])) {
                        q1.add(gate);
                        map[gate[0]][gate[1]] = '*';
                    } else {
                        q3.add(gate);
                    }
                }

                q2 = q3;
                q3 = new LinkedList<>();
            }

            System.out.println(count);
        }
    }
}
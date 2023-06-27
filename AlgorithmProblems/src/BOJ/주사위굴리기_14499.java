package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 주사위굴리기_14499 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = num[0], m = num[1], x = num[2], y = num[3];

        int[][] map = new int[n][];
        for (int i = 0; i < n; i++) map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] moves = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Dice dice = new Dice();

        for (int d : moves) {
            int tx = x;
            int ty = y;

            switch (d) {
                case 1:
                    y++;
                    break;
                case 2:
                    y--;
                    break;
                case 3:
                    x--;
                    break;
                default:
                    x++;
                    break;
            }

            if (x < 0 || y < 0 || x >= n || y >= m) {
                x = tx;
                y = ty;
                continue;
            }

            dice.move(d);
            dice.copy(x, y, map);
            System.out.println(dice.u);
        }
    }

    public static class Dice {

        int u;
        int d;
        int r;
        int l;
        int f;
        int b;

        void copy(int x, int y, int[][] map) {
            if (map[x][y] == 0) {
                map[x][y] = d;
            } else {
                d = map[x][y];
                map[x][y] = 0;
            }
        }

        void move(int move) {
            int temp = u;

            switch (move) {
                case 1:
                    u = l;
                    l = d;
                    d = r;
                    r = temp;
                    break;
                case 2:
                    u = r;
                    r = d;
                    d = l;
                    l = temp;
                    break;
                case 3:
                    u = f;
                    f = d;
                    d = b;
                    b = temp;
                    break;
                default:
                    u = b;
                    b = d;
                    d = f;
                    f = temp;
                    break;
            }
        }
    }
}
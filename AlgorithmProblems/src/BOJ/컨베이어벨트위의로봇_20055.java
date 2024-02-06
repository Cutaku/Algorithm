package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 컨베이어벨트위의로봇_20055 {
    static int n;
    static int k;
    static int[] conveyor;
    static boolean[] robots;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = nk[0];
        k = nk[1];

        conveyor = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        robots = new boolean[n];

        int count = 0;

        while (k > 0) {
            count++;

            rotate();
            move();
            load();
        }

        System.out.println(count);
    }

    static void load() {

        if (conveyor[0] > 0) {
            conveyor[0]--;
            robots[0] = true;

            if (conveyor[0] == 0) k--;
        }
    }

    static void move() {

        for (int i = n - 1; i > 0; i--) {
            if (conveyor[i] > 0 && !robots[i] && robots[i - 1]) {
                conveyor[i]--;
                robots[i] = true;
                robots[i - 1] = false;

                if (conveyor[i] == 0) k--;
            }
        }

        robots[n - 1] = false;
    }

    static void rotate() {

        int t = conveyor[2 * n - 1];
        for (int i = 2 * n - 1; i > 0; i--) conveyor[i] = conveyor[i - 1];
        conveyor[0] = t;

        for (int i = n - 2; i > 0; i--) robots[i] = robots[i - 1];
        robots[0] = false;
    }
}
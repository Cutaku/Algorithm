package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 컨베이어벨트위의로봇_20055 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0], k = nk[1];

        int[] durability = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean[] robots = new boolean[n];

        int count = 0;

        do {
            rotate(durability, robots);
            move(durability, robots);
            loadRobot(durability, robots);
            count++;
        } while (check(durability, k));

        System.out.println(count);
    }

    static void rotate(int[] durability, boolean[] robots) {

        int n = durability.length / 2;

        int temp = durability[2 * n - 1];

        for (int i = 2 * n - 1; i > 0; i--) durability[i] = durability[i - 1];
        durability[0] = temp;

        for (int i = n - 2; i > 0; i--) robots[i] = robots[i - 1];
        robots[0] = false;
    }

    static void move(int[] durability, boolean[] robots) {

        int n = durability.length / 2;

        for (int i = n - 2; i >= 0 ; i--) {
            if (!robots[i] || robots[i + 1] || durability[i + 1] == 0) continue;

            robots[i + 1] = true;
            robots[i] = false;
            durability[i + 1]--;
        }

        if (robots[n - 1]) robots[n - 1] = false;
    }

    static void loadRobot(int[] durability, boolean[] robots) {

        if (durability[0] > 0) {
            durability[0]--;
            robots[0] = true;
        }
    }

    static boolean check(int[] durability, int k) {

        int count = 0;

        for (int d : durability) {
            if (d == 0) count ++;
        }

        return (k > count);
    }
}
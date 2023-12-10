package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 고기잡이_7573 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = numbers[0], l = numbers[1], m = numbers[2];

        l /= 2;

        List<int[]> fishes = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            fishes.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }

        Set<Integer> X = new HashSet<>();
        Set<Integer> Y = new HashSet<>();

        for (int[] fish : fishes) {
            X.add(fish[0]);
            Y.add(fish[1]);
        }

        int max = 0;

        for (int x : X) {
            for (int y : Y) {
                max = Math.max(max, countFishes(fishes, x, y, l));
            }
        }

        for (int[] fish : fishes) {
            for (int i = 0; i < l; i++) {
                for (int j = 0; i + j <= l; j++) {
                    int x = fish[0] + i;
                    int y = fish[1] + j;

                    max = Math.max(max, countFishes(fishes, x, y, l));
                }
            }
        }



        System.out.println(max);
    }

    public static int countFishes(List<int[]> fishes, int x, int y, int l) {

        int max = 0;

        for (int i = 1; i < l; i++) {
            if (x < i || y < l - i) continue;

            int count = 0;

            for (int[] fish : fishes) {
                if (x - i <= fish[0] && fish[0] <= x && y - l + i <= fish[1] && fish[1] <= y) count++;
            }

            max = Math.max(max, count);
        }

        return max;
    }
}
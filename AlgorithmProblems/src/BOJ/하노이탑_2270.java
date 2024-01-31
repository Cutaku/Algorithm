package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 하노이탑_2270 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int d = 1000000;

        int[] move = new int[100001];
        for (int i = 1; i <= 100000; i++) {
            move[i] = (move[i - 1] * 2 + 1) % d;
        }

        int n = Integer.parseInt(br.readLine());

        int[] abc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] where = new int[n + 1];

        for (int i = 0; i < 3; i++) {
            if (abc[i] == 0) continue;

            int w = i;
            Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .forEach(num -> where[num] = w);
        }

        int count = 0;

        int target = where[n];

        System.out.println(target + 1);

        for (int i = n - 1; i > 0; i--) {
            if (where[i] == target) continue;

            target = 3 - target - where[i];

            count += 1 + move[i - 1];

            count %= d;
        }

        System.out.println(count);
    }
}
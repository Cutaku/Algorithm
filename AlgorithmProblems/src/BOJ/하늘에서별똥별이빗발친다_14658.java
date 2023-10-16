package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 하늘에서별똥별이빗발친다_14658 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int l = numbers[2], k = numbers[3];

        int[][] stars = new int[k][];
        for (int i = 0; i < k; i++) stars[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int max = 0;

        for (int i = 0; i < k; i++) {
            for (int j = i; j < k; j++) {
                if (Math.abs(stars[i][0] - stars[j][0]) > l || Math.abs(stars[i][1] - stars[j][1]) > l) continue;

                int x = Math.min(stars[i][0], stars[j][0]);
                int y = Math.min(stars[i][1], stars[j][1]);

                int count = 0;

                for (int[] star : stars) {
                    if (x <= star[0] && star[0] <= x + l && y <= star[1] && star[1] <= y + l) count++;
                }

                max = Math.max(max, count);
            }
        }

        System.out.println(k - max);
    }
}
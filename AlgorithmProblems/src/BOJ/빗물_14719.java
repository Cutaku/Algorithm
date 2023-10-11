package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 빗물_14719 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] hw = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int h = hw[0], w = hw[1];

        int[] blocks = Arrays.stream((br.readLine() + " 0").split(" ")).mapToInt(Integer::parseInt).toArray();

        int count = 0;

        for (int i = 0; i < h; i++) {
            int s = 0;
            while (s < w && blocks[s] <= i) s++;

            if (s == w) continue;

            int t = 0;

            for (int j = s + 1; j < w; j++) {
                if (blocks[j] <= i) {
                    t++;
                } else {
                    count += t;
                    t = 0;
                }
            }
        }

        System.out.println(count);
    }
}
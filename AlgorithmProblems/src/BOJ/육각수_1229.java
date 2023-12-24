package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 육각수_1229 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> hexas = new ArrayList<>();

        int h = 1;

        for (int i = 1; h <= n; i++) {
            hexas.add(h);

            h += i * 4 + 1;
        }

        int[] count = new int[n + 1];
        Arrays.fill(count, 6);

        count[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int hexa : hexas) {
                if (hexa > i) break;
                count[i] = Math.min(count[i], count[i - hexa] + 1);
            }
        }

        System.out.println(count[n]);
    }
}
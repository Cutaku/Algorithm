package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 줄세우기_7570 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] children = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] position = new int[n];

        for (int i = 0; i < n; i++) {
            position[children[i] - 1] = i;
        }

        int max = 1;

        int c = 1;

        for (int i = 1; i < n; i++) {
            if (position[i - 1] < position[i]) {
                c++;
                max = Math.max(max, c);
            } else {
                c = 1;
            }
        }

        System.out.println(n - max);
    }
}
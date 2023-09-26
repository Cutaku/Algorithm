package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 선긋기_2170 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] lines = new int[n][];
        for (int i = 0; i < n; i++) lines[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(lines, (l1, l2) -> {
            if (l1[0] == l2[0]) return l1[1] - l2[1];
            else return l1[0] - l2[0];
        });

        int s = Integer.MIN_VALUE;
        int e = Integer.MIN_VALUE;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            int[] line = lines[i];

            if (e < line[0]) {
                sum += e - s;
                s = line[0];
            }

            e = Math.max(e, line[1]);
        }

        sum += e - s;

        System.out.println(sum);
    }
}
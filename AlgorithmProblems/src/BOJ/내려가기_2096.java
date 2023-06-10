package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 내려가기_2096 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] min = new int[3];
        int[] max = new int[3];

        for (int i = 0; i < n; i++) {
            int[] scores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[] t_min = new int[3];
            int[] t_max = new int[3];

            t_min[0] = Math.min(min[0], min[1]) + scores[0];
            t_min[1] = Math.min(Math.min(min[0], min[1]), min[2]) + scores[1];
            t_min[2] = Math.min(min[1], min[2]) + scores[2];

            t_max[0] = Math.max(max[0], max[1]) + scores[0];
            t_max[1] = Math.max(Math.max(max[0], max[1]), max[2]) + scores[1];
            t_max[2] = Math.max(max[1], max[2]) + scores[2];

            min = t_min;
            max = t_max;
        }

        System.out.print(Math.max(Math.max(max[0], max[1]), max[2]) + " ");
        System.out.println(Math.min(Math.min(min[0], min[1]), min[2]));
    }
}
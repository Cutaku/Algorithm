package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 시간관리_1263 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] tasks = new int[n][];
        for (int i = 0; i < n; i++) tasks[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(tasks, Comparator.comparingInt(t -> t[1] * -1));

        int t = Integer.MAX_VALUE;

        for (int[] task : tasks) {
            t = Math.min(t, task[1]);

            t -= task[0];

            if (t < 0) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(t);
    }
}
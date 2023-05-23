package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 텀프로젝트_9466 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            int[] students = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < n; i++) students[i]--;

            int[] checked = new int[n];

            int count = 0;

            int num = 1;

            for (int i = 0; i < n; i++) {
                int j = i;

                int start = num;

                while (checked[j] == 0) {
                    checked[j] = num++;

                    j = students[j];
                }

                if (checked[j] >= start) count += checked[j] - start;
                else count += num - start;
            }

            System.out.println(count);
        }
    }
}
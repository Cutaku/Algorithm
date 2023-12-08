package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 비단조성_4237 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            boolean up = false;

            int count = 1;

            for (int i = 2; i < arr.length; i++) {
                if ((up && arr[i] > arr[i - 1]) || (!up && arr[i] < arr[i - 1])) {
                    count++;
                    up = !up;
                }
            }

            System.out.println(count);
        }
    }
}
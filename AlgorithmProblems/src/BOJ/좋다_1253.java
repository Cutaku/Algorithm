package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 좋다_1253 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(numbers);

        int count = 0;

        for (int i = 0; i < n; i++) {
            int s = 0;
            int e = n - 1;

            while (s < e) {
                if (s == i || numbers[s] + numbers[e] < numbers[i]) {
                    s++;
                } else if (e == i || numbers[s] + numbers[e] > numbers[i]) {
                    e--;
                }
                else {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
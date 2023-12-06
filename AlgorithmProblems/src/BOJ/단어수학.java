package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class 단어수학 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Integer[] count = new Integer[100];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            char[] number = br.readLine().toCharArray();

            for (int j = 0; j < number.length; j++) {
                count[number[j]] += (int) Math.pow(10, number.length - 1 - j);
            }
        }

        Arrays.sort(count, Collections.reverseOrder());

        int ans = 0;

        for (int i = 0; i < 10; i++) {
            if (count[i] == 0) break;

            ans += count[i] * (9 - i);
        }

        System.out.println(ans);
    }
}
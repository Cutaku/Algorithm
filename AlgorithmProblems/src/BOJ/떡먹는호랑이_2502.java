package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 떡먹는호랑이_2502 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int d = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        int[] one = new int[d + 1], two = new int[d + 1];
        one[1] = 1;
        two[2] = 1;

        for (int i = 3; i <= d; i++) {
            one[i] += one[i - 1] + one[i - 2];
            two[i] += two[i - 1] + two[i - 2];
        }

        int a = 1;

        while (true) {
            if ((k - a * one[d]) % two[d] == 0) {
                System.out.println(a);
                System.out.println((k - a * one[d]) / two[d]);
                break;
            }

            a++;
        }
    }
}
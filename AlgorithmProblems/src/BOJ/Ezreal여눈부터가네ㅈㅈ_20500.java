package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ezreal여눈부터가네ㅈㅈ_20500 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int d = 1000000007;

        int n = Integer.parseInt(br.readLine());

        int[] rest = new int[15];
        rest[1] = 1;
        rest[5] = 1;

        for (int i = 0; i < n - 1; i++) {
            int[] temp = new int[15];

            for (int j = 0; j < 15; j++) {
                int r1 = (10 * j + 1) % 15;
                int r2 = (10 * j + 5) % 15;

                temp[r1] = (temp[r1] + rest[j]) % d;
                temp[r2] = (temp[r2] + rest[j]) % d;
            }

            rest = temp;
        }

        System.out.println(rest[0]);
    }
}
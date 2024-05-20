package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 돌게임6_9660 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        String[] win = {"CY", "SK", "CY", "SK", "SK", "SK", "SK"};

        System.out.println(win[(int) (n % 7)]);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬수_1259 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();

            if (str.equals("0")) break;

            int l = str.length();

            boolean isPalindrome = true;

            for (int i = 0; i <= l / 2; i++) {
                if (str.charAt(i) != str.charAt(l - 1 - i)) {
                    isPalindrome = false;
                    break;
                }
            }

            if (isPalindrome) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
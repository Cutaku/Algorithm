package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 무한이진트리탐색_2963 {
    static int d = 100000000;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        BigInteger ans = new BigInteger("1");
        BigInteger cnt = new BigInteger("1");

        BigInteger two = new BigInteger("2");
        BigInteger three = new BigInteger("3");
        BigInteger five = new BigInteger("5");

        String line = br.readLine();

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'L') {
                ans = ans.multiply(two);
            } else if (line.charAt(i) == 'R') {
                ans = ans.multiply(two);
                ans = ans.add(cnt);
            } else if (line.charAt(i) == '*'){
                ans = ans.multiply(five);
                ans = ans.add(cnt);
                cnt = cnt.multiply(three);
            }
        }

        System.out.println(ans);
    }
}
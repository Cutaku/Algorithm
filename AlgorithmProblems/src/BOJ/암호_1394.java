package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 암호_1394 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int l = s.length();

        int[] arr = new int[300];
        for (int i = 0; i < l; i++) arr[s.charAt(i)]  = i + 1;

        String password = br.readLine();

        long ans = 0;
        int d = 900528;
        long p = 1;

        for (int i = password.length() - 1; i >= 0; i--) {
            ans = (ans + p * arr[password.charAt(i)]) % d;
            p = (p * l) % d;
        }

        System.out.println(ans);
    }
}
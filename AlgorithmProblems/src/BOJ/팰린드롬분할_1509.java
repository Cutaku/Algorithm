package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬분할_1509 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();

        int l = arr.length;

        boolean[][] isPalindrome = new boolean[l][l];

        for (int i = 0; i < l; i++) isPalindrome[i][i] = true;

        for (int i = 1; i < l; i++) {
            if (arr[i - 1] == arr[i]) isPalindrome[i - 1][i] = true;
        }

        for (int d = 2; d < l; d++) {
            for (int i = 0; i + d < l; i++) {
                if (isPalindrome[i + 1][i + d - 1] && arr[i] == arr[i + d]) {
                    isPalindrome[i][i + d] = true;
                }
            }
        }

        int[] count = new int[l];

        for (int i = 0; i < l; i++) {
            count[i] = Integer.MAX_VALUE;

            for (int j = 0; j <= i; j++) {
                if (isPalindrome[j][i]) {
                    if (j == 0) count[i] = 1;
                    else count[i] = Math.min(count[i], count[j - 1] + 1);
                }
            }
        }

        System.out.println(count[l - 1]);
    }
}
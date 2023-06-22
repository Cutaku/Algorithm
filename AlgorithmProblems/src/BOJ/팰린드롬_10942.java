package BOJ;

import java.io.*;
import java.util.Arrays;

public class 팰린드롬_10942 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int m = Integer.parseInt(br.readLine());

        boolean[][] isPalindrome = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) isPalindrome[i][i] = true;

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] == arr[i]) isPalindrome[i][i + 1] = true;
        }

        for (int d = 2; d < n; d++) {
            for (int i = 1; i + d <= n ; i++) {
                if (arr[i - 1] == arr[i + d - 1] && isPalindrome[i + 1][i + d - 1]) isPalindrome[i][i + d] = true;
            }
        }

        for (int i = 0; i < m; i++) {
            int[] question = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (isPalindrome[question[0]][question[1]]) bw.append("1\n");
            else bw.append("0\n");
        }

        bw.flush();
    }
}
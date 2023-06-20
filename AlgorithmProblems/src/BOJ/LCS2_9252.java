package BOJ;

import java.io.*;
import java.util.Stack;

public class LCS2_9252 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int n = str1.length();
        int m = str2.length();

        int[][] ans = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(j - 1) == str2.charAt(i - 1)) {
                    ans[i][j] = ans[i - 1][j - 1] + 1;
                } else {
                    ans[i][j] = Math.max(ans[i][j - 1], ans[i - 1][j]);
                }
            }
        }

        System.out.println(ans[m][n]);

        Stack<Character> stack = new Stack<>();

        int i = n;
        int j = m;

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                stack.add(str1.charAt(--i));
                j--;
            } else if (ans[j][i - 1] > ans[j - 1][i]) {
                i--;
            } else {
                j--;
            }
        }

        while (!stack.isEmpty()) bw.append(stack.pop());
        bw.flush();
    }
}
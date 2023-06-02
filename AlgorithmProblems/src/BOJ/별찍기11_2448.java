package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별찍기11_2448 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] blanks = new String[n / 2 + 1];
        blanks[0] = "";
        for (int i = 1; i <= n / 2; i++) blanks[i] = blanks[i - 1] + " ";

        String[] answer = new String[3];
        answer[0] = "  *  ";
        answer[1] = " * * ";
        answer[2] = "*****";

        while (n % 2 == 0) {
            answer = twice(answer, blanks);
            n /= 2;
        }

        for (String line : answer) {
            System.out.println(line);
        }
    }

    public static String[] twice(String[] answer, String[] blanks) {

        int n = answer.length;
        int l = answer[n - 1].length();

        String[] result = new String[n * 2];

        for (int i = 0; i < n; i++) {
            result[i] = blanks[n] + answer[i] + blanks[n];
            result[n + i] = answer[i] + blanks[1] + answer[i];
        }

        return result;
    }
}
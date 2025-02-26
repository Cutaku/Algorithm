package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 트리복구_6597 {
    static StringBuilder sb;
    static char[] pre, in;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();

        String input;

        while ((input = br.readLine()) != null) {
            String[] orders = input.split(" ");

            pre = orders[0].toCharArray();
            in = orders[1].toCharArray();

            int n = pre.length;

            post(0, 0, n);

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void post(int s1, int s2, int l) {

        char p = pre[s1];

        int left = 0;
        while (in[s2 + left] != p) left++;

        int right = l - left - 1;

        if (left > 0) post(s1 + 1, s2, left);
        if (right > 0) post(s1 + left + 1, s2 + left + 1, right);
        sb.append(p);
    }
}
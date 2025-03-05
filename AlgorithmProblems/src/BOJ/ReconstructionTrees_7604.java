package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReconstructionTrees_7604 {
    static StringBuilder sb;
    static char[] pre, in;
    static boolean flag;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        StringBuilder ans = new StringBuilder();

        while (!(input = br.readLine()).equals("#")) {
            String[] orders = input.split(" ");

            pre = orders[0].toCharArray();
            in = orders[1].toCharArray();
            sb = new StringBuilder();
            flag = true;

            int n = pre.length;

            post(0, 0, n);

            if (flag) ans.append(sb).append("\n");
            else ans.append("Invalid tree.\n");
        }

        System.out.println(ans);
    }

    static void post(int s1, int s2, int l) {

        char p = pre[s1];

        int left = 0;
        while (left < l && in[s2 + left] != p) left++;

        if (left == l) {
            flag = false;
            return;
        }

        int right = l - left - 1;

        if (left > 0) post(s1 + 1, s2, left);
        if (right > 0) post(s1 + left + 1, s2 + left + 1, right);
        sb.append(p);
    }
}
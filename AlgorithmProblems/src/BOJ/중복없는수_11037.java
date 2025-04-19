package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 중복없는수_11037 {
    static int[] B;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        B = new int[257];
        for (int i = 0; i < 9; i++) B[1 << i] = i + 1;

        list = new ArrayList<>();

        dfs(0, 511, 0);

        Collections.sort(list);

        String input;

        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);

            if (n == 0) {
                sb.append("1\n");
                continue;
            } else if (n >= 987654321) {
                sb.append("0\n");
                continue;
            }

            int s = 0, e = list.size() - 1;

            while (e - s > 1) {
                int m = (s + e) >> 1;

                if (list.get(m) > n) e = m;
                else s = m;
            }

            sb.append(list.get(e)).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int d, int left, int sum) {

        if (d > 0) list.add(sum);

        if (left == 0) return;

        int l = left;

        while (l > 0) {
            int b = l & -l;
            l -= b;

            dfs(d + 1, left - b, 10 * sum + B[b]);
        }
    }
}
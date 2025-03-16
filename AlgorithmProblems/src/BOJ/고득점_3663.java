package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 고득점_3663 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String word = br.readLine();
            int l = word.length();

            int ans = 0;
            List<Integer> change = new ArrayList<>();

            for (int i = 0; i < l; i++) {
                char c = word.charAt(i);

                if (c != 'A') {
                    change.add(i);
                    ans += Math.min(c - 'A', 'Z' + 1 - c);
                }
            }

            int s = change.size();

            if (s > 0) {
                int min = Math.min(l - change.getFirst(), change.getLast());

                for (int i = 0; i < s - 1; i++) {
                    min = Math.min(min, 2 * change.get(i) + l - change.get(i + 1));
                    min = Math.min(min, 2 * (l - change.get(i + 1)) + change.get(i));
                }

                ans += min;
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
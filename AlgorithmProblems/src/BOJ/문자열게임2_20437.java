package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 문자열게임2_20437 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());

            List<Integer>[] list = new List[26];
            for (int i = 0; i < 26; i++) list[i] = new ArrayList<>();

            int min = 10001;
            int max = 0;

            for (int i = 0; i < str.length(); i++) {
                int idx = str.charAt(i) - 'a';

                list[idx].add(i);

                if (list[idx].size() >= k) {
                    int d = i + 1 - list[idx].get(list[idx].size() - k);

                    min = Math.min(min, d);
                    max = Math.max(max, d);
                }
            }

            if (max > 0) {
                sb.append(min).append(" ").append(max).append("\n");
            } else {
                sb.append("-1\n");
            }
        }

        System.out.println(sb);
    }
}
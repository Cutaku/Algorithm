package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 다이어트_1484 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int g = Integer.parseInt(br.readLine());

        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i < Math.sqrt(g); i++) {
            if (g % i > 0) continue;

            int n = g / i;

            if ((i + n) % 2 == 1) continue;

            ans.add((i + n) / 2);
        }

        if (ans.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int i = ans.size() - 1; i >= 0; i--) {
                sb.append(ans.get(i)).append("\n");
            }

            System.out.print(sb);
        }
    }
}
package SWExpertAcademy;

import java.io.*;
import java.util.Arrays;

public class 식료품가게_19113 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            bw.append("#").append(String.valueOf(t)).append(" ");

            int n = Integer.parseInt(br.readLine());

            int[] prices = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            boolean[] checked = new boolean[2 * n];

            for (int i = 0; i < 2 * n; i++) {
                if (checked[i]) continue;

                checked[i] = true;

                bw.append(String.valueOf(prices[i])).append(" ");

                int price = prices[i] / 3 * 4;

                for (int j = i + 1; j < 2 * n; j++) {
                    if (prices[j] == price && !checked[j]) {
                        checked[j] = true;
                        break;
                    }
                }
            }

            bw.append("\n");
        }

        bw.flush();
    }
}
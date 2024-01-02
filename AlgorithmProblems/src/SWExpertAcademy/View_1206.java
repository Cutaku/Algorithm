package SWExpertAcademy;

import java.io.*;
import java.util.Arrays;

public class View_1206 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t = 1; t <= 10; t++) {
            bw.append("#").append(String.valueOf(t)).append(" ");

            int n = Integer.parseInt(br.readLine());

            int[] buildings = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int sum = 0;

            for (int i = 2; i < n - 2; i++) {
                int visible = buildings[i];

                for (int j = i - 2; j <= i + 2; j++) {
                    if (i == j) continue;

                    visible = Math.min(visible, Math.max(0, buildings[i] - buildings[j]));
                }

                sum += visible;
            }

            bw.append(String.valueOf(sum)).append("\n");
        }

        bw.flush();
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 칸토어집합_4779 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] cantor = new String[13];
        String[] blank = new String[13];
        cantor[0] = "-";
        blank[0] = " ";

        for (int i = 1; i < 13; i++) {
            StringBuilder s = new StringBuilder();
            s.append(cantor[i - 1]).append(blank[i - 1]).append(cantor[i - 1]);
            cantor[i] = s.toString();

            s = new StringBuilder();
            s.append(blank[i - 1]).append(blank[i - 1]).append(blank[i - 1]);
            blank[i] = s.toString();
        }

        String input;

        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);

            sb.append(cantor[n]).append("\n");
        }

        System.out.println(sb);
    }
}
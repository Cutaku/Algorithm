package SWExpertAcademy;

import java.io.*;
import java.util.Arrays;

public class 만화책정렬하기_8191 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            bw.append("#").append(String.valueOf(tc)).append(" ");

            int n = Integer.parseInt(br.readLine());

            int[] comics = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] order = new int[n];

            for (int i = 0; i < n; i++) {
                order[comics[i] - 1] = i;
            }

            int c = 1;

            for (int i = 1; i < n; i++) {
                if (order[i] < order[i - 1]) c++;
            }

            bw.append(String.valueOf(c)).append("\n");
        }

        bw.flush();
    }
}
package SWExpertAcademy;

import java.io.*;

public class 현주가좋아하는제곱근놀이_6782 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            bw.append("#").append(String.valueOf(tc)).append(" ");

            long n = Long.parseLong(br.readLine());

            long count = 0;

            while (n > 2) {
                long s = (int) Math.sqrt(n);

                if (s * s == n) {
                    n = s;
                    count++;
                    continue;
                }

                count += (s + 1) * (s + 1) - n;

                n = (s + 1) * (s + 1);
            }

            bw.append(String.valueOf(count)).append("\n");
        }

        bw.flush();
    }
}
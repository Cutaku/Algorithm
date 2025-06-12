package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일과오_33615 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int c1 = 0, c2 = 0;
            int i1 = 999999, i2 = 999999;

            String line = br.readLine();

            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '1') {
                    c1++;
                    i1 = Math.min(i1, i + 1);
                } else {
                    c2++;
                    i2 = Math.min(i2, i + 1);
                }
            }

            int r = (c1 + 2 * c2) % 3;

            if (r == 0) {
                sb.append("0 3");
            } else if (r == 1) {
                if (c1 > 0) sb.append(i1).append(" 3");
                else sb.append("0 5");
            } else {
                if (c2 > 0) sb.append(i2).append(" 3");
                else {
                    if (c1 % 2 == 0) sb.append("0 11");
                    else sb.append("1 11");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
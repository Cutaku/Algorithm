package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 전화번호수수께끼_Large_14370 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("Case #").append(tc).append(": ");

            int[] chars = new int['Z' + 1];

            String s = br.readLine();

            for (int i = 0; i < s.length(); i++) {
                chars[s.charAt(i)]++;
            }

            int[] count = new int[10];

            count[0] = chars['Z'];
            count[2] = chars['W'];
            count[4] = chars['U'];
            count[6] = chars['X'];
            count[8] = chars['G'];
            count[1] = chars['O'] - count[0] - count[2] - count[4];
            count[3] = chars['H'] - count[8];
            count[5] = chars['F'] - count[4];
            count[7] = chars['S'] - count[6];
            count[9] = (chars['N'] - count[1] - count[7]) / 2;

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < count[i]; j++) {
                    sb.append(i);
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
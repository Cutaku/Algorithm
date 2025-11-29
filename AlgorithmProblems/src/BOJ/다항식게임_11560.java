package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다항식게임_11560 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        long[][] coefficient = new long[21][211];

        coefficient[1][0] = 1;
        coefficient[1][1] = 1;

        int d = 1;

        for (int i = 1; i < 20; i++) {
            for (int j = 0; j <= d; j++) {
                for (int k = 0; k < i + 2; k++) {
                    coefficient[i + 1][j + k] += coefficient[i][j];
                }
            }

            d += i + 1;
        }


        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            sb.append(coefficient[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]).append("\n");
        }

        System.out.println(sb);
    }
}
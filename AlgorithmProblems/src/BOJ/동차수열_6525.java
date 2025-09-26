package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동차수열_6525 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n;
        int[][] square;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while ((n = Integer.parseInt(br.readLine())) != 0) {
            square = new int[n][n];
            boolean flag = true;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    square[i][j] = Integer.parseInt(st.nextToken());

                    if (square[i][j] - square[i][0] != square[0][j] - square[0][0] ||
                            square[i][j] - square[0][j] != square[i][0] - square[0][0])  flag = false;
                }
            }

            sb.append(flag ? "homogeneous\n" : "not homogeneous\n");
        }

        System.out.println(sb);
    }
}
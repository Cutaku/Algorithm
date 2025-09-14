package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 분배_11391 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = 1 << Integer.parseInt(st.nextToken()), k = 1 << Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        int x = 0;

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n / k / 2; j++) {
                sb.append(x).append(" ").append(n - ++x).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 덧셈_10504 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[900001];
        for (int i = 0; i < 900000; i++) {
            arr[i + 1] = arr[i] + i;
        }

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            if (n == 1) {
                sb.append("IMPOSSIBLE\n");
                continue;
            }

            for (int i = 2; i < 900001; i++) {
                if (n < arr[i]) {
                    sb.append("IMPOSSIBLE\n");
                    break;
                }

                if ((n - arr[i]) % i == 0) {
                    sb.append(n).append(" = ");

                    sb.append((n - arr[i]) / i);

                    for (int j = 1; j < i; j++) {
                        sb.append(" + ").append((n - arr[i]) / i + j);
                    }

                    sb.append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}
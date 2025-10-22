package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 럭키세븐_28706 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            boolean[] check = new boolean[7];
            check[1] = true;

            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                boolean[] tmp = new boolean[7];

                for (int j = 0; j < 2; j++) {
                    if (st.nextToken().equals("+")) {
                        int v = Integer.parseInt(st.nextToken());

                        for (int k = 0; k < 7; k++) {
                            if (check[k]) tmp[(k + v) % 7] = true;
                        }
                    } else {
                        int v = Integer.parseInt(st.nextToken());

                        for (int k = 0; k < 7; k++) {
                            if (check[k]) tmp[(k * v) % 7] = true;
                        }
                    }
                }

                check = tmp;
            }

            sb.append(check[0] ? "LUCKY\n" : "UNLUCKY\n");
        }

        System.out.println(sb);
    }
}
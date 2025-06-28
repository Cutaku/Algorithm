package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이차원배열다중업데이트다중합_25978 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        long[][] arr = new long[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }

        long[][] diff = new long[n + 1][n + 1];

        boolean flag = false;

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < m; t++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int i1 = Integer.parseInt(st.nextToken()), j1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken()), j2 = Integer.parseInt(st.nextToken());

            if (a == 1) {
                long k = Long.parseLong(st.nextToken());

                diff[i1][j1] += k;
                diff[i1][j2 + 1] -= k;
                diff[i2 + 1][j1] -= k;
                diff[i2 + 1][j2 + 1] += k;
            } else {
                if (!flag) {
                    for (int i = 0; i < n; i++) {
                        for (int j = 1; j < n; j++) {
                            diff[i][j] += diff[i][j - 1];
                        }
                    }

                    for (int i = 1; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            diff[i][j] += diff[i - 1][j];
                        }
                    }

                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            arr[i + 1][j + 1] += diff[i][j];
                        }
                    }

                    for (int i = 1; i <= n; i++) {
                        for (int j = 1; j <= n; j++) {
                            arr[i][j] += arr[i - 1][j];
                        }
                    }

                    for (int i = 1; i <= n; i++) {
                        for (int j = 1; j <= n; j++) {
                            arr[i][j] += arr[i][j - 1];
                        }
                    }

                    flag = true;
                }

                sb.append(arr[i2 + 1][j2 + 1] - arr[i2 + 1][j1] - arr[i1][j2 + 1] + arr[i1][j1]).append("\n");
            }
        }

        System.out.println(sb);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 삭삽정렬_13884 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());

            sb.append(k).append(" ");

            int[][] arr = new int[n][];

            for (int i = 0; i < n; i++) {
                if (i % 10 == 0) st = new StringTokenizer(br.readLine());

                arr[i] = new int[]{Integer.parseInt(st.nextToken()), i};
            }

            Arrays.sort(arr, (a, b) -> {
                if (a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            });

            int res = n - 1;

            for (int i = 1; i < n; i++) {
                if (arr[i][1] > arr[i - 1][1]) {
                    res--;
                } else {
                    int idx = i + 1;

                    while (idx < n && arr[idx][0] == arr[idx - 1][0]) {
                        if (arr[i - 1][1] < arr[idx++][1]) res--;
                    }

                    break;
                }
            }

            sb.append(res).append("\n");
        }

        System.out.println(sb);
    }
}
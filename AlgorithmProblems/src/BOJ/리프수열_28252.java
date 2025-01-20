package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 리프수열_28252 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        arr[n] = 100001;

        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];

            if (arr[i] > arr[i + 1]) {
                System.out.println(-1);
                return;
            }
        }

        if (arr[1] == 1) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sum).append("\n");

        if (arr[0] > 2) {
            System.out.println(-1);
            return;
        } else if (arr[0] == 2) {
            sb.append("1 2\n");
        }

        int start = 1;
        int num = arr[0] + 1;

        for (int i = 1; i < n; i++) {
            int tmp = num;

            for (int j = 0; j < arr[i - 1] - 1; j++) {
                sb.append(start++).append(" ").append(num++).append("\n");
            }

            for (int j = 0; j <= arr[i] - arr[i - 1]; j++) {
                sb.append(start).append(" ").append(num++).append("\n");
            }

            start = tmp;
        }

        System.out.println(sb);
    }
}
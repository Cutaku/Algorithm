package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소트_1083 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int s = Integer.parseInt(br.readLine());

        int idx = 0;

        while (s > 0 && idx < n) {
            int max = 0;
            int mIdx = 0;

            for (int i = idx; i <= Math.min(n - 1, idx + s); i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    mIdx = i;
                }
            }

            move(arr, idx, mIdx);

            s -= mIdx - idx++;
        }

        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }

    static void move(int[] arr, int l, int r) {

        int t = arr[r];

        for (int i = r; i > l; i--) {
            arr[i] = arr[i - 1];
        }

        arr[l] = t;
    }
}
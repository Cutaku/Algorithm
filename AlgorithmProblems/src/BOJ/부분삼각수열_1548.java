package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부분삼각수열_1548 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int max = Math.min(n, 2);

        for (int i = 0; i < n - 2; i++) {
            for (int j = n - 1; j > i + 1; j--) {
                if (arr[i] + arr[i + 1] > arr[j]) {
                    max = Math.max(max, j - i + 1);
                    break;
                }
            }
        }

        System.out.println(max);
    }
}
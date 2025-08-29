package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 차이를최대로2_16193 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int s = 0, e = n - 1;
        long ans = arr[e] - arr[s];

        for (int i = 0; i < (n - 2) / 2; i++)  ans += arr[e] + arr[--e] - arr[s] - arr[++s];
        if (n % 2 == 1) ans += Math.max(arr[e] - arr[e - 1], arr[s + 1] - arr[s]);

        System.out.println(ans);
    }
}
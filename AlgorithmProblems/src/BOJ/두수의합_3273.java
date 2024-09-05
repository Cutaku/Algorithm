package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두수의합_3273 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int x = Integer.parseInt(br.readLine());

        int s = 0, e = n - 1;

        int ans = 0;

        while (e > s) {
            int sum = arr[s] + arr[e];

            if (sum > x) e--;
            else if (sum < x) s++;
            else {
                ans++;
                s++;
            }
        }

        System.out.println(ans);
    }
}
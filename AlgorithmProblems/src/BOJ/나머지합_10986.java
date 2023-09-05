package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 나머지합_10986 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        arr[0] %= m;

        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
            arr[i] %= m;
        }

        int[] count = new int[m];

        for (int r : arr) {
            count[r]++;
        }

        long ans = 0L;

        for (int i = 0; i < m; i++) {
            long l = count[i];

            ans += l * (l - 1) / 2;
        }

        ans += count[0];

        System.out.println(ans);
    }
}
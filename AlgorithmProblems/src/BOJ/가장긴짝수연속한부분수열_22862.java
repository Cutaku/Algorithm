package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 가장긴짝수연속한부분수열_22862 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0], k = nk[1];

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int i = 0;
        int j = 0;

        int odd = 0;
        int even = 0;

        if (arr[0] % 2 == 1) odd++;
        else even++;

        int max = even;

        while (j < n - 1) {
            if (odd > k) {
                if (arr[i] % 2 == 1) odd--;
                else even--;
                i++;
            } else if (arr[j + 1] % 2 == 1) {
                odd++;
                j++;
            } else  {
                even++;
                j++;
                max = Math.max(even, max);
            }
        }

        System.out.println(max);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 소풍_1242 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nkm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nkm[0], k = nkm[1], m = nkm[2] - 1;

        int p = 0;

        for (int i = 0; i < n; i++) {
            p += k - 1;
            p %= n - i;

            if (p == m) {
                System.out.println(i + 1);
                return;
            } else if (p < m) {
                m--;
            }
        }
    }
}
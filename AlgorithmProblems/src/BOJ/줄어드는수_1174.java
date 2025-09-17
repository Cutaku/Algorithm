package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 줄어드는수_1174 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n > 1023) {
            System.out.println(-1);
            return;
        }

        long[] arr = new long[1024];
        for (int i = 1; i < 1024; i++) arr[i] = toDesc(i);

        Arrays.sort(arr);

        System.out.println(arr[n]);
    }

    static long toDesc(int idx) {

        long res = 0;
        long d = 1L;

        for (int i = 0; i < 10; i++) {
            if (idx % 2 == 1) {
                res += d * i;
                d *= 10;
            }

            idx /= 2;
        }

        return res;
    }
}
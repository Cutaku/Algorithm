package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일의개수세기_9527 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] ab = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long a = ab[0], b = ab[1];

        System.out.println(countOne(b) - countOne(a - 1));
    }   

    static long countOne(long n) {

        if (n == 0) return 0;

        int i = 0;
        long b = 1l;

        while (b * 2 <= n) {
            i++;
            b *= 2;
        }

        long r = n - b;

        return i * (b / 2) + r + 1 + countOne(r);
    }
}
package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class 반복하지않는수_7696_BF {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] b = new boolean[10];

        int[] ans = IntStream.range(0,26195084).filter(n -> {
            Arrays.fill(b, false);
            while (n > 0) {
                if (b[n % 10]) return false;
                b[n % 10] = true;
                n /= 10;
            }
            return true;
        }).toArray();

        int n;

        while ((n = Integer.parseInt(br.readLine())) > 0) bw.append(String.valueOf(ans[n])).append("\n");

        bw.flush();
    }
}
package BOJ;

import java.io.*;
import java.util.Arrays;

public class 가희와탑_24337 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nab = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nab[0], a = nab[1], b = nab[2];

        if (a + b > n + 1) {
            System.out.println(-1);
            return;
        }

        if (a == 1) {
            bw.append(String.valueOf(b)).append(" ");
            for (int i = 0; i < n - b; i++) bw.append("1 ");
            for (int i = b - 1; i > 0; i--) bw.append(String.valueOf(i)).append(" ");
        } else {
            for (int i = 0; i < n - a - b + 2; i++) bw.append("1 ");
            for (int i = 2; i < a; i++) bw.append(String.valueOf(i)).append(" ");
            bw.append(String.valueOf(Math.max(a, b))).append(" ");
            for (int i = b - 1; i > 0; i--) bw.append(String.valueOf(i)).append(" ");
        }

        bw.flush();
    }
}
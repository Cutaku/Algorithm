package BOJ;

import java.io.*;
import java.util.Arrays;

public class 이진수찾기_2248 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] nli = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        int n = (int)nli[0], l = (int)nli[1];
        long i = nli[2];

        int[][] total = new int[n][l + 1];

        int[] count = new int[l + 1];

        for (int j = 0; j < n; j++) {
            int[] temp = new int[l + 1];

            temp[0] = 1;

            total[j][0] = 1;

            int t = 1;

            for (int k = 1; k <= l; k++) {
                temp[k] += count[k] + count[k - 1];
                t += temp[k];

                total[j][k] = t;
            }

            count = temp;
        }

        for (int j = n - 1; j >= 0 ; j--) {
            if (i > total[j][l]) {
                bw.append(String.valueOf(1));
                i -= total[j][l];
                l--;
            } else {
                bw.append(String.valueOf(0));
            }
        }

        bw.flush();
    }
}
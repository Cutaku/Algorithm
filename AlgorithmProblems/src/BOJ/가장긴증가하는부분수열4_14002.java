package BOJ;

import java.io.*;
import java.util.Arrays;

public class 가장긴증가하는부분수열4_14002 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] lca = new int[n + 1];
        int[] before = new int[n + 1];

        int c = 0;

        for (int i = 0; i < n; i++) {
            if (c == 0 || arr[i] > arr[lca[c - 1]]) {
                if (c > 0) before[i] = lca[c - 1];
                lca[c++] = i;
                continue;
            } else if (arr[i] == arr[lca[c - 1]]) {
                continue;
            } else if (arr[i] < arr[lca[0]]) {
                lca[0] = i;
                continue;
            }

            int s = 0;
            int e = c - 1;

            while (e - s > 1) {
                int m = (e + s) / 2;

                if (arr[i] < arr[lca[m]]) e = m;
                else s = m;
            }

            if (arr[i] == arr[lca[s]]) continue;

            lca[e] = i;
            before[i] = lca[s];
        }

        bw.append(String.valueOf(c)).append("\n");

        int ind = lca[c - 1];

        int[] inds = new int[c];

        while (c > 0) {
            inds[--c] = ind;

            ind = before[ind];
        }

        for (int i : inds) {
            bw.append(String.valueOf(arr[i])).append(" ");
        }

        bw.flush();
    }
}
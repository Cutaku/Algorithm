package BOJ;

import java.io.*;
import java.util.Arrays;

public class 넴모넴모2020_19845 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int q = nq[1];

        int[] nem = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < q; i++) {
            int[] laser = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            bw.append(String.valueOf(Math.max(countNem(nem, laser[0]) - laser[1] + 1, 0) + Math.max(0, (nem[laser[1] - 1] - laser[0])))).append("\n");
        }

        bw.flush();
    }

    public static int countNem(int[] nem, int x) {

        int s = 0;
        int e = nem.length;

        if (nem[e - 1] >= x) return e;
        if (nem[s] < x) return s;

        while (e - s > 1) {
            int m = (s + e) / 2;

            if (nem[m] >= x) s = m;
            else e = m;
        }

        return e;
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ㄷㄷㄷㅈ_19535 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] count = new long[n];
        int[][] edges = new int[n - 1][];

        StringTokenizer st;

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;

            count[v1]++;
            count[v2]++;

            edges[i] = new int[]{v1, v2};
        }

        long d = 0;
        long g = count[n - 1] * (count[n - 1] - 1) * (count[n - 1] - 2) / 6;

        for (int i = 0; i < n - 1; i++) {
            int v1 = edges[i][0], v2 = edges[i][1];

            d += (count[v1] - 1) * (count[v2] - 1);
            g += count[i] * (count[i] - 1) * (count[i] - 2) / 6;
        }

        if (d > g * 3) System.out.println("D");
        else if (d < g * 3) System.out.println("G");
        else System.out.println("DUDUDUNGA");
    }
}
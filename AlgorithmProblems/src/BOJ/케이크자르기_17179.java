package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 케이크자르기_17179 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] cut = new int[m + 1];
        for (int i = 0; i < m; i++) cut[i] = Integer.parseInt(br.readLine());

        cut[m] = l;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int q = Integer.parseInt(br.readLine()) + 1;

            int s = 1, e = l;

            while (e - s > 1) {
                int a = (s + e) >> 1;

                if (check(cut, a) >= q) s = a;
                else e = a;
            }

            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

    static int check(int[] cut, int a) {

        int s = 0;
        int cnt = 0;

        for (int c : cut) {
            if (c - s >= a) {
                cnt++;
                s = c;
            }
        }

        return cnt;
    }
}
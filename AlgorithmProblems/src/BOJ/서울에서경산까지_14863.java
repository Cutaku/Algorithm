package BOJ;

import java.io.*;
import java.util.*;

public class 서울에서경산까지_14863 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[] count = new int[m + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());

            count[Integer.parseInt(st.nextToken()) - 1]++;

            for (int j = 0; j < k - 2; j++) st.nextToken();

            count[Integer.parseInt(st.nextToken()) - 1]++;
        }

        for (int i = 0; i < m; i++) {
            count[i + 1] += count[i];

            if (count[i] >= n) {
                System.out.println(i + 1);
                return;
            }
        }
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 신을모시는사당_27210 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = st.nextToken().charAt(0) == '1';

        int max = -1;
        int min = 1;

        int s1 = 0;
        int s2 = 0;

        for (int i = 0; i < n; i++) {
            s1 += arr[i] ? 1 : -1;
            s2 += arr[i] ? 1 : -1;

            max = Math.max(max, s1);
            min = Math.min(min, s2);

            if (s1 < 0) s1 = 0;
            if (s2 > 0) s2 = 0;
        }

        System.out.println(Math.max(max, -min));
    }
}
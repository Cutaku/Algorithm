package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 자와각도기_2916 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        int g = 360;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) g = gcd(g, Integer.parseInt(st.nextToken()));

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            sb.append(Integer.parseInt(st.nextToken()) % g == 0 ? "YES\n" : "NO\n");
        }

        System.out.println(sb);
    }

    static int gcd(int a, int b) {

        return  b == 0 ? a : gcd(b, a % b);
    }
}
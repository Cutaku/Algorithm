package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 반짝반짝2_22984 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        double a = Double.parseDouble(st.nextToken());
        double ans = a;

        for (int i = 1; i < n; i++) {
            double b = Double.parseDouble(st.nextToken());
            ans += (1 - b) * a + (2 - a) * b;
            a = b;
        }

        System.out.println(ans);
    }
}
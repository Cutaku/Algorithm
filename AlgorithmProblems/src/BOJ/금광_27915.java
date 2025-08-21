package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 금광_27915 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] isEven = new boolean[n];
        isEven[0] = true;

        StringTokenizer st = new StringTokenizer(br.readLine());

        int even = 1;
        int odd = 0;

        for (int i = 1; i < n; i++) {
            if (isEven[i] = !isEven[Integer.parseInt(st.nextToken()) - 1]) even++;
            else odd++;
        }

        System.out.println(Math.max(even, odd));
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 점모으기_7571 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[] X = new int[m];
        int[] Y = new int[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(X);
        Arrays.sort(Y);

        int x = X[m / 2];
        int y = Y[m / 2];

        int sum = 0;

        for (int i = 0; i < m; i++) {
            sum += Math.abs(x - X[i]);
            sum += Math.abs(y - Y[i]);
        }

        System.out.println(sum);
    }
}
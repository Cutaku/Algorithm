package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 다각형의면적_2166 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        double[][] points = new double[n + 1][];

        for (int i = 0; i < n; i++) points[i] = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        points[n] = points[0];

        double ans = 0;

        for (int i = 0; i < n; i++) {
            ans += points[i][0] * points[i + 1][1] - points[i][1] * points[i + 1][0];
        }

        ans = Math.abs(ans / 2);

        System.out.printf("%.1f", ans);
    }
}
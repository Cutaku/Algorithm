package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AxBsinxC_2_14786 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        double a = Integer.parseInt(st.nextToken());
        double b = Integer.parseInt(st.nextToken());
        double c = Integer.parseInt(st.nextToken());

        double e = 1e-9;

        double x1 = 0, x2 = 200000;

        while (x2 - x1 >= e) {
            double x = (x1 + x2) / 2;

            if (a * x + b * Math.sin(x) >= c)  x2 = x;
            else x1 = x;
        }

        System.out.println((x1 + x2) / 2);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 전구상태뒤집기_25634 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int sum = 0;

        int max = Integer.MIN_VALUE;
        int cont = 0;

        for (int i = 0; i < n; i++) {
            int bulb = Integer.parseInt(st1.nextToken());
            int on = Integer.parseInt(st2.nextToken());

            sum += bulb * on;

            cont += bulb * (on == 1 ? -1 : 1);

            max = Math.max(cont, max);

            cont = Math.max(0, cont);
        }

        System.out.println(sum + max);
    }
}
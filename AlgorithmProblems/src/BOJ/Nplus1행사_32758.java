package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Nplus1행사_32758 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());

        StringTokenizer event = new StringTokenizer(br.readLine());
        StringTokenizer goal = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int n = Integer.parseInt(event.nextToken());
            int a = Integer.parseInt(goal.nextToken());

            if (n >= a) sb.append(a).append(" ");
            else sb.append(a - (a - 1) / n).append(" ");
        }

        System.out.println(sb);
    }
}
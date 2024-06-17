package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 멍멍이쓰다듬기_1669 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());

        int d = y - x;
        int t = 0;
        long cover = 0;


        while (d > cover) {
            cover += (t++ + 2) / 2;
        }

        System.out.println(t);
    }
}
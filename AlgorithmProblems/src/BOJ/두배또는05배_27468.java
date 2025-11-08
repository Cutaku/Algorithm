package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 두배또는05배_27468 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int s;
        int[] add;

        if (n % 4 == 2) {
            s = 2;
            add = new int[]{-1, 2, 1, 2};
        } else {
            s = 1;
            add = new int[]{2, -1 ,2, 1};
        }

        StringBuilder sb = new StringBuilder();
        sb.append("YES\n");

        for (int i = 0; i < n; i++) {
            sb.append(s).append(" ");
            s += add[i % 4];
        }

        System.out.println(sb);
    }
}
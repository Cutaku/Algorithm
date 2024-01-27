package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 로봇프로젝트_3649 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while ((input = br.readLine()) != null) {
            int x = Integer.parseInt(input) * 10000000;

            int n = Integer.parseInt(br.readLine());

            int[] legos = new int[n];

            for (int i = 0; i < n; i++) {
                legos[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(legos);

            int s = 0;
            int e = Math.max(n - 1, 0);

            while (s < e) {
                if (legos[s] + legos[e] > x) {
                    e--;
                } else if (legos[s] + legos[e] < x) {
                    s++;
                } else {
                    System.out.printf("yes %d %d\n", legos[s], legos[e]);
                    break;
                }
            }

            if (s == e) System.out.println("danger");

            input = null;
        }
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 방법을출력하지않는숫자맞추기_13392 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String e = br.readLine();

        int[] dif = new int[n];
        for (int i = 0; i < n; i++) {
            dif[i] = s.charAt(n - 1 - i) - e.charAt(n - 1 - i);
            if (dif[i] < 0) dif[i] += 10;
        }

        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            int[] temp = new int[10];

            for (int j = 0; j < 10; j++) {
                int d = (dif[i] + j) % 10;
                temp[j] = Math.min(count[j] + d, count[(j + 10 - d) % 10] + 10 - d);
            }

            count = temp;
        }

        System.out.println(count[0]);
    }
}
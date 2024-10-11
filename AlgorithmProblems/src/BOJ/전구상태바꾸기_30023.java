package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 전구상태바꾸기_30023 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] red = new int[n];
        int[] green = new int[n];
        int[] blue = new int[n];

        String input = br.readLine();
        for (int i = 0; i < n; i++) {
            if (input.charAt(i) == 'R') {
                blue[i] = 1;
                green[i] = 2;
            } else if (input.charAt(i) == 'G') {
                red[i] = 1;
                blue[i] = 2;
            } else {
                green[i] = 1;
                red[i] = 2;
            }
        }

        int r = 0, g = 0, b = 0;

        for (int i = 0; i < n - 2; i++) {
            if (red[i] % 3 == 1) {
                red[i] += 2;
                red[i + 1] += 2;
                red[i + 2] += 2;
                r += 2;
            } else if (red[i] % 3 == 2) {
                red[i] += 1;
                red[i + 1] += 1;
                red[i + 2] += 1;
                r += 1;
            }

            if (green[i] % 3 == 1) {
                green[i] += 2;
                green[i + 1] += 2;
                green[i + 2] += 2;
                g += 2;
            } else if (green[i] % 3 == 2) {
                green[i] += 1;
                green[i + 1] += 1;
                green[i + 2] += 1;
                g += 1;
            }

            if (blue[i] % 3 == 1) {
                blue[i] += 2;
                blue[i + 1] += 2;
                blue[i + 2] += 2;
                b += 2;
            } else if (blue[i] % 3 == 2) {
                blue[i] += 1;
                blue[i + 1] += 1;
                blue[i + 2] += 1;
                b += 1;
            }
        }

        int min = Integer.MAX_VALUE;

        if (red[n - 2] % 3 == 0 && red[n - 1] % 3 == 0) min = r;
        if (green[n - 2] % 3 == 0 && green[n - 1] % 3 == 0) min = Math.min(min, g);
        if (blue[n - 2] % 3 == 0 && blue[n - 1] % 3 == 0) min = Math.min(min, b);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
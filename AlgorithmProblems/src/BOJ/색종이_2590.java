package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 색종이_2590 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] count = new int[6];
        for (int i = 0; i < 6; i++) count[i] = Integer.parseInt(br.readLine());

        int ans = count[3] + count[4] + count[5];

        count[0] -= 11 * count[4];
        count[1] -= 5 * count[3];

        ans += (count[2] + 3) / 4;

        switch (count[2] % 4) {
            case 1 : {
                count[1] -= 5;
                count[0] -= 7;
                break;
            }
            case 2 : {
                count[1] -= 3;
                count[0] -= 6;
                break;
            }
            case 3 : {
                count[1] -= 1;
                count[0] -= 5;
                break;
            }
            default:
        }

        int a = Math.max(0, (count[1] + 8) / 9);
        ans += a;
        count[1] -= 9 * a;
        count[0] += 4 * count[1];

        ans += Math.max(0, (count[0] + 35) / 36);

        System.out.println(ans);
    }
}
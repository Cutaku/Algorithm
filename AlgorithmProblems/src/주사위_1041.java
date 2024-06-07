import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위_1041 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        int sum = 0;
        int max = 0;

        int[] dice = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++){
            dice[i] = Integer.parseInt(st.nextToken());
            sum += dice[i];
            max = Math.max(max, dice[i]);
        }

        int one = min(dice);

        int two = min(dice[0] + dice[1], dice[0] + dice[2], dice[0] + dice[3], dice[0] + dice[4],
                dice[1] + dice[2], dice[2] + dice[4], dice[4] + dice[3], dice[3] + dice[1],
                dice[1] + dice[5], dice[2] + dice[5], dice[3] + dice[5], dice[4] + dice[5]);

        int three = min(dice[0] + dice[1] + dice[2], dice[0] + dice[2] + dice[4], dice[0] + dice[4] + dice[3],
                dice[0] + dice[3] + dice[1], dice[5] + dice[1] + dice[2], dice[5] + dice[2] + dice[4],
                dice[5] + dice[4] + dice[3], dice[5] + dice[3] + dice[1]);

        if (n == 1) System.out.println(sum - max);
        else System.out.println(4 * three + (8 * n - 12) * two + (n - 2) * (5 * n - 6) * one);
    }

    static int min(int... arr) {

        int m = 1000;

        for (int num : arr) {
            m = Math.min(m, num);
        }

        return m;
    }
}
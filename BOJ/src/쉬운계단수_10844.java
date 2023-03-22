import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쉬운계단수_10844 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[12];
        for (int i = 2; i < 11; i++) {
            stair[i] = 1;
        }

        int d = 1000000000;

        for (int i = 0; i < n - 1; i++) {
            int[] temp = new int[12];

            for (int j = 1; j < 11; j++) {
                temp[j] = (stair[j - 1] + stair[j + 1]) % d;
            }

            stair = temp;
        }

        int sum = 0;
        for (int i : stair) {
            sum = (sum + i) % d;
        }

        System.out.println(sum);
    }
}
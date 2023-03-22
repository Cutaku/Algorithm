import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 제곱수의합_1699 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] squares = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            squares[i] = squares[i - 1] + 1;

            for (int j = 2; j * j <= i; j++) {
                squares[i] = Math.min(squares[i], squares[i - j * j] + 1);
            }
        }

        System.out.println(squares[n]);
    }
}
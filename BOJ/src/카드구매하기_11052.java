import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 카드구매하기_11052 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] prices = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] arr = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < prices.length + 1; j++) {
                if (i >= j) arr[i] = Math.max(arr[i], arr[i - j] + prices[j - 1]);
            }
        }

        System.out.println(arr[n]);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 합분해2_13707 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0], k = nk[1];

        int[] count = new int[n + 1];
        Arrays.fill(count, 1);

        for (int i = 0; i < k - 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                count[j] += count[j - 1];
                count[j] %= 1000000000;
            }
        }

        System.out.println(count[n]);
    }
}
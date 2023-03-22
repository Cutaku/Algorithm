import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 신을모시는사당_코테1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] statues = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int max = 0;

        int countLeft = 0;
        int countRight = 0;

        for (int statue : statues) {
            if (statue == 1) {
                countLeft++;
                countRight--;
            } else {
                countLeft--;
                countRight++;
            }

            if (countLeft > max) max = countLeft;
            if (countRight > max) max = countRight;

            if (countLeft < 0) countLeft = 0;
            if (countRight < 0) countRight = 0;
        }

        System.out.println(max);
    }
}
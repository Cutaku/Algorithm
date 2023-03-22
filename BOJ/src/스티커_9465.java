import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 스티커_9465 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] secondLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[] arr = new int[3];
            arr[0] = firstLine[0];
            arr[1] = secondLine[0];

            for (int i = 1; i < n; i++) {
                int[] temp = new int[3];
                temp[0] = Math.max(arr[1], arr[2]) + firstLine[i];
                temp[1] = Math.max(arr[0], arr[2]) + secondLine[i];
                temp[2] = Math.max(arr[0], arr[1]);

                arr = temp;
            }

            System.out.println(Math.max(Math.max(arr[0], arr[1]), arr[2]));
        }
    }
}
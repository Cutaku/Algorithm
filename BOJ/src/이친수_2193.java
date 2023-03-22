import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이친수_2193 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[2];
        arr[1] = 1;

        for (int i = 0; i < n - 1; i++) {
            long[] temp = new long[2];

            temp[0] = arr[0] + arr[1];
            temp[1] = arr[0];

            arr = temp;
        }

        System.out.println(arr[0] + arr[1]);
    }
}
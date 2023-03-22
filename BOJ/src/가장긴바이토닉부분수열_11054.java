import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 가장긴바이토닉부분수열_11054 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] a = br.readLine().split(" ");
        int[] A = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(a[i - 1]);
        }

        int[] arr1 = new int[n + 1];
        int[] arr2 = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int[] temp1 = new int[i];
            int[] temp2 = new int[i];

            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) temp1[j] = arr1[j];
                if (A[n + 1 - j] < A[n + 1 - i]) temp2[j] = arr2[j];
            }

            arr1[i] = max(temp1) + 1;
            arr2[i] = max(temp2) + 1;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = arr1[i + 1] + arr2[n - i] - 1;
        }

        System.out.println(max(arr));
    }

    static int max(int[] arr) {
        int result = arr[0];

        for (int i : arr) {
            result = Math.max(result, i);
        }

        return result;
    }
}
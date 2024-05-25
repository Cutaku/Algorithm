package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IQTest_1111 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        if (n == 1) {
            System.out.println("A");
        } else if (n == 2) {
            if (arr[0] == arr[1]) {
                System.out.println(arr[0]);
            } else {
                System.out.println("A");
            }
        } else {
            int a, b;

            if (arr[0] == arr[1]) {
                a = 1;
                b = 0;
            } else {
                if ((arr[2] - arr[1]) % (arr[1] - arr[0]) != 0) {
                    System.out.println('B');
                    return;
                }

                a = (arr[2] - arr[1]) / (arr[1] - arr[0]);
                b = arr[1] - arr[0] * a;
            }

            for (int i = 1; i < n - 1; i++) {
                if (arr[i + 1] != a * arr[i] + b) {
                    System.out.println('B');
                    return;
                }
            }

            System.out.println(arr[n - 1] * a + b);
        }
    }
}
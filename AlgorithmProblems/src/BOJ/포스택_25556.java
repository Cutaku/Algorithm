package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 포스택_25556 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[4];

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            if (!add(arr, Integer.parseInt(st.nextToken()))) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    static boolean add(int[] arr, int a) {

        Arrays.sort(arr);

        for (int i = 3; i >= 0; i--) {
            if (arr[i] < a) {
                arr[i] = a;
                return true;
            }
        }

        return false;
    }
}
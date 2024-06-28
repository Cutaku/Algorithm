package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동작그만밑장빼기냐_20159 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = n >> 1;

        int[] odd = new int[m + 1];
        int[] even = new int[m + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= m; i++) {
            odd[i] = Integer.parseInt(st.nextToken());
            even[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= m; i++) {
            odd[i] += odd[i - 1];
            even[i] += even[i - 1];
        }

        int max = Math.max(odd[m], even[m]);

        for (int i = 1; i <= m; i++) {
            max = Math.max(max, odd[i] + even[m] - even[i]);
            max = Math.max(max, odd[i] + even[m - 1] - even[i - 1]);
        }

        System.out.println(max);
    }
}
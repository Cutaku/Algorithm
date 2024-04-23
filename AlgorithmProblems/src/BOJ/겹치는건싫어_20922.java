package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 겹치는건싫어_20922 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] count = new int[100001];

        int s = 0, e = 0;

        int max = 1;
        count[arr[0]]++;

        while (e < n) {
            if (count[arr[e]] > k) {
                count[arr[s++]]--;
            } else {
                max = Math.max(max, e - s + 1);
                if (++e < n) count[arr[e]]++;
            }
        }

        System.out.println(max);
    }
}
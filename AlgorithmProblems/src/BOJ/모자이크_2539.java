package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 모자이크_2539 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int s = 0, e = Math.max(r, c);

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());

            s = Math.max(s, x);
            arr[i] = y;
        }

        Arrays.sort(arr);
        s--;

        while (e - s > 1) {
            int m = (s + e) >> 1;

            if (check(arr, m, p)) e = m;
            else s = m;
        }

        System.out.println(e);
    }


    static boolean check(int[] arr, int m, int p) {

        int last = 0;
        int cnt = 0;

        for (int a : arr) {
            if (last <= a) {
                cnt++;
                last = a + m;
            }

            if (cnt > p) return false;
        }

        return true;
    }
}
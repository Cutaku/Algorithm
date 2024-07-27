package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 고냥이_16472 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[] arr = br.readLine().toCharArray();

        int s = 0, e = 0;

        int[] count = new int[26];
        count[arr[0] - 'a'] = 1;
        int c = 1;
        int max = 1;

        while (e < arr.length - 1) {
            if (count[arr[e + 1] - 'a'] > 0 || c < n) {
                max = Math.max(max, ++e - s + 1);
                if (count[arr[e] - 'a']++ == 0) c++;
            } else {
                if (count[arr[s++] - 'a']-- == 1) c--;
            }
        }

        System.out.println(max);
    }
}
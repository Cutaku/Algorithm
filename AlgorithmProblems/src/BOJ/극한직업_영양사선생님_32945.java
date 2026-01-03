package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 극한직업_영양사선생님_32945 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] times = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) times[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(times, Collections.reverseOrder());

        int[] cnt = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (i > 0) cnt[i] += cnt[i - 1];
            if (i + times[i] < n) cnt[i + times[i]]--;

            max = Math.max(max, ++cnt[i]);
        }

        System.out.println(max);
    }
}
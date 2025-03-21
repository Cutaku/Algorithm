package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 회전초밥_15961 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[n + k - 1];

        for (int i = 0; i < k - 1; i++) {
            sushi[i] = sushi[i + n] = Integer.parseInt(br.readLine());
        }

        for (int i = k - 1; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d + 1];
        int cnt = 0;

        count[c]++;
        cnt++;

        for (int i = 0; i < k; i++) {
            int s = sushi[i];

            if (count[s] == 0) cnt++;

            count[s]++;
        }

        int max = cnt;

        for (int i = k; i < n + k - 1; i++) {
            int s = sushi[i];
            if (count[s] == 0) cnt++;
            count[s]++;

            s = sushi[i - k];
            count[s]--;
            if (count[s] == 0) cnt--;

            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
}
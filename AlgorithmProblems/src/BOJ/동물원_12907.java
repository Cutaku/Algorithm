package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동물원_12907 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int c = Integer.parseInt(st.nextToken());

            if (c >= n) end();

            cnt[c]++;
        }

        int one = 0;
        int two = 0;

        for (int i = 0; i < n; i++) {
            if (cnt[i] > 2) end();
            if (i > 0 && cnt[i] > cnt[i - 1]) end();

            if (cnt[i] == 2) two++;
            else if (cnt[i] == 1) one++;
        }

        long ans = 1;
        for (int i = 0; i < two; i++) ans <<= 1;

        if (one > 0) ans <<= 1;

        System.out.println(ans);
    }

    static void end() {

        System.out.println("0");
        System.exit(0);
    }
}
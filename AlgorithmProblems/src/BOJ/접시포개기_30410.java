package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 접시포개기_30410 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        int a = 1;
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int b = Integer.parseInt(st.nextToken());

            if (a == b) {
                cnt++;
            } else {
                list.add(cnt);
                cnt = 1;
                a = 3 - a;
            }
        }

        list.add(cnt);
        int l = list.size();

        int max = 0;
        int cur = 0;

        for (int i = 0; i < l; i++) {
            if (i % 2 == 1) {
                cur += list.get(i);
            } else {
                cur += list.get(i) / 2;

                if (list.get(i) % 2 == 1) {
                    max = Math.max(max, cur);
                    cur = list.get(i) / 2;
                }
            }
        }

        max = Math.max(max, cur);

        int ans = 1;

        while (max > 0) {
            ans <<= 1;
            max >>= 1;
        }

        System.out.println(ans);
    }
}
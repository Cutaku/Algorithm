package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 수들의합4_2015 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        Map<Long, List<Integer>> map = new HashMap<>();

        long[] sum = new long[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());

            if (!map.containsKey(sum[i])) {
                map.put(sum[i], new ArrayList<>());
            }

            map.get(sum[i]).add(i);
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            if (map.containsKey(k + sum[i])) {
                ans += count(map.get(k + sum[i]), i);
            }
        }

        System.out.println(ans);
    }

    static int count(List<Integer> list, int i) {

        if (list.get(0) > i) return list.size();
        if (list.get(list.size() - 1) <= i) return 0;

        int s = 0, e = list.size() - 1;

        while (e - s > 1) {
            int m = (s + e) >> 1;

            if (list.get(m) > i) e = m;
            else s = m;
        }

        return list.size() - e;
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 대도시구축_34016 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long ans = n - 2 + n * (n + 1) / 2;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (!map.containsKey(x)) map.put(x, new ArrayList<>());
            if (!map.containsKey(y)) map.put(y, new ArrayList<>());

            map.get(x).add(y);
            map.get(y).add(x);
        }

        for (int key : map.keySet()) {
            if (key == 1 || !map.get(key).contains(1)) continue;

            ans++;

            if (key == 2) {
                ans++;

                if (map.get(key).contains(3)) ans++;
            } else {
                if (map.get(key).contains(2)) {
                    if (key == 3) ans += 2;
                    else ans++;
                }
            }
        }

        if (map.containsKey(1) && map.get(1).contains(2) && map.get(1).contains(3)) ans++;

        System.out.println(ans);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 부분수열의중앙값_3013 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == b) {
                idx = i;
                break;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int cnt = 0;
        for (int i = idx - 1; i >= 0; i--) {
            cnt += arr[i] > b ? 1 : -1;

            map.put(cnt, map.getOrDefault(cnt, 0) + 1);
        }


        long ans = map.get(0);

        cnt = 0;
        for (int i = idx + 1; i < n; i++) {
            cnt += arr[i] > b ? -1 : 1;

            ans += map.getOrDefault(cnt, 0);
        }

        System.out.println(ans);
    }
}
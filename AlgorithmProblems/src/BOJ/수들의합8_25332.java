package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 수들의합8_25332 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        StringTokenizer a =  new StringTokenizer(br.readLine());
        StringTokenizer b =  new StringTokenizer(br.readLine());

        int sum = 0;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(a.nextToken()) - Integer.parseInt(b.nextToken());

            int c = map.getOrDefault(sum, 0);

            ans += c;
            map.put(sum, c + 1);
        }

        System.out.println(ans);
    }
}
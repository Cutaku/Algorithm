package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 무한수열_1351 {
    static long n;
    static int p, q;
    static Map<Long, Long> map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        map = new HashMap<>();

        System.out.println(find(n));
    }

    static long find(long n) {

        if (n == 0) return 1;

        if (map.containsKey(n)) return map.get(n);

        long res = find(n / p) + find(n / q);

        map.put(n, res);

        return res;
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class 과녁맞추기_27516 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());

        Map<Key, Integer> left = new HashMap<>();
        Map<Key, Integer> right = new HashMap<>();

        int max = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long xi = Long.parseLong(st.nextToken()) - x;
            long yi = Long.parseLong(st.nextToken()) - y;

            if (xi == 0 || yi >= 0) continue;

            Map<Key, Integer> map = xi < 0 ? left : right;
            xi = Math.abs(xi);
            xi *= xi;
            yi = -yi;

            long g = gcd(xi, yi);
            xi = xi / g;
            yi = yi / g;

            Key key = new Key(xi, yi);

            map.put(key, map.getOrDefault(key, 0) + 1);

            max = Math.max(max, map.get(key));
        }

        System.out.println(max);
    }

    static long gcd(long a, long b) {

        return b == 0 ? a : gcd(b, a % b);
    }

    static class Key {

        long a, b;

        public Key(long a, long b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return a == key.a && b == key.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}
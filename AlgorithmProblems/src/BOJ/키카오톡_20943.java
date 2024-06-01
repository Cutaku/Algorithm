package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class 키카오톡_20943 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Map<Vec, Long> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int d = gcd(Math.abs(x), Math.abs(y));
            x /= d;
            y /= d;

            new Vec(x, y).add(map);
        }

        long ans = 0;

        for (Vec v : map.keySet()) {
            ans += map.get(v) * (n - map.get(v));
        }

        System.out.println(ans / 2);
    }

    static class Vec {
        int x, y;

        public Vec(int x, int y) {
            if (x < 0) {
                x *= -1;
                y *= -1;
            } else if (x == 0 && y < 0) {
                y *= -1;
            }

            this.x = x;
            this.y = y;
        }

        void add(Map<Vec, Long> map) {
            if (map.containsKey(this)) {
                map.put(this, map.get(this) + 1);
            } else {
                map.put(this, 1L);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vec vec = (Vec) o;
            return x == vec.x && y == vec.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static int gcd(int a, int b) {

        if (b > a) {
            int t = a;
            a = b;
            b = t;
        }

        while (b > 0) {
            int t = b;
            b = a % b;
            a = t;
        }

        return a;
    }
}
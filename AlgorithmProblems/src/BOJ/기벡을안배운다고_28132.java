package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class 기벡을안배운다고_28132 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Map<Vec, Long> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        long zero = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == 0 && y == 0) {
                zero++;
                continue;
            }

            int d = gcd(Math.abs(x), Math.abs(y));
            x /= d;
            y /= d;

            add(map, new Vec(x, y));
        }

        long ans = 0;

        for (Vec v : map.keySet()) {
            int x = v.y, y = -v.x;

            Vec w = new Vec(x, y);

            if (map.containsKey(w)) {
                ans += map.get(v) * map.get(w);
            }
        }

        ans /= 2;

        ans += zero * (n - zero);
        ans += zero * (zero - 1) / 2;

        System.out.println(ans);
    }

    static void add(Map<Vec, Long> map, Vec vec) {

        if (map.containsKey(vec)) {
            map.put(vec, map.get(vec) + 1);
        } else {
            map.put(vec, 1L);
        }
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
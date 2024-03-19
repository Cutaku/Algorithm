package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 톱니바퀴_14891 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Wheel wheel = new Wheel(Integer.parseInt(br.readLine(), 2), Integer.parseInt(br.readLine(), 2),
                Integer.parseInt(br.readLine(), 2), Integer.parseInt(br.readLine(), 2));

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            wheel.rotate(Integer.parseInt(st.nextToken()) - 1, st.nextToken().equals("1"));
        }

        System.out.println(wheel.countScore());
    }

    static class Wheel {
        int[] wheels;

        public Wheel(int... w) {
            wheels = w;
        }

        void rotate(int w, boolean clockwise) {
            int l = 0, r = 0;

            while (w - l > 0 && mesh(wheels[w - l - 1], wheels[w - l])) l++;
            while (w + r < 3 && mesh(wheels[w + r], wheels[w + r + 1])) r++;

            if (l % 2 > 0) clockwise = !clockwise;

            for (int i = w - l; i <= w + r; i++) {
                wheels[i] = rot(wheels[i], clockwise);
                clockwise = !clockwise;
            }
        }

        int countScore() {
            int sum = 0;

            for (int i = 0; i < 4; i++) {
                if ((wheels[i] & 128) > 0) sum |= 1 << i;
            }

            return sum;
        }
    }

    static boolean mesh(int left, int right) {

        return ((right ^ (left >> 4)) & 2) > 0;
    }

    static int rot(int w, boolean clockwise) {

        if (clockwise) {
            w |= (w & 1) << 8;
            w >>= 1;
        } else {
            w <<= 1;
            w = (w + w / 256) & 255;
        }

        return w;
    }
}
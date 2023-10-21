package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 도서관_1461 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = nm[1];

        int[] positions = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int l = 0;
        int r = 0;

        for (int position : positions) {
            if (position < 0) {
                l = Math.max(l, position * -1);
                left.add(position);
            } else {
                r = Math.max(r, position);
                right.add(position * -1);
            }
        }

        int ans = 0;

        int ls = left.size();
        int rs = right.size();

        for (int i = 0; i < ls; i++) {
            if (i % m == 0) {
                ans -= 2 * left.poll();
            } else {
                left.poll();
            }
        }

        for (int i = 0; i < rs; i++) {
            if (i % m == 0) {
                ans -= 2 * right.poll();
            } else {
                right.poll();
            }
        }

        ans -= Math.max(l, r);

        System.out.println(ans);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 수상택시_2836 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        List<int[]> backward = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[] passenger = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int from = passenger[0], to = passenger[1];

            if (from > to) backward.add(new int[]{to, from});
        }

        backward.sort((p1, p2) -> {
            if (p1[0] == p2[0]) return p1[1] - p2[1];
            else return p1[0] - p2[0];
        });

        long sum = m;

        int s = 0;
        int e = 0;

        for (int[] back : backward) {
            if (e < back[0]) {
                sum += (e - s) * 2;
                s = back[0];
            }

            e = Math.max(e, back[1]);
        }

        sum += (e - s) * 2;

        System.out.println(sum);
    }
}
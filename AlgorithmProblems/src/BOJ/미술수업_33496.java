package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 미술수업_33496 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        Set<Integer> sum = new HashSet<>();

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            positive.add(x + y);
            negative.add(x - y);
            sum.add(x + y);
            sum.add(x - y);
        }

        positive = positive.stream().distinct().sorted().collect(Collectors.toList());
        negative = negative.stream().distinct().sorted().collect(Collectors.toList());

        int idx = 0;

        long ans = sum.size();

        for (int p : positive) {
            while (idx < negative.size() && negative.get(idx) < p) idx++;

            ans += idx;
        }

        System.out.println(ans);
    }
}
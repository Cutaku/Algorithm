package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 전구장식_5527 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        int last = Integer.parseInt(st.nextToken());
        int c = 1;

        for (int i = 1; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());

            if (last == a) {
                list.add(c);
                c = 1;
            } else {
                last = a;
                c++;
            }
        }

        list.add(c);

        int sum = list.get(0);
        if (list.size() > 1) sum += list.get(1);
        if (list.size() > 2) sum += list.get(2);

        int ans = sum;

        for (int i = 3; i < list.size(); i++) {
            sum += list.get(i) - list.get(i - 3);
            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }
}
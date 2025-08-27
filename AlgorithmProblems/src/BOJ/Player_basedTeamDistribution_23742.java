package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Player_basedTeamDistribution_23742 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        long sum = 0, res = 0;
        List<Long> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            long a = Long.parseLong(st.nextToken());

            if (a < 0) {
                list.add(a);
                res += a;
            } else {
                cnt++;
                sum += a;
            }
        }

        long max = cnt * sum + res;

        Collections.sort(list, Collections.reverseOrder());

        for (Long a : list) {
            cnt++;
            sum += a;
            res -= a;

            max = Math.max(max, cnt * sum + res);
        }

        System.out.println(max);
    }
}
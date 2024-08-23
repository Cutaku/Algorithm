package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 문제추천시스템Version1_21939 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        TreeSet<int[]> set = new TreeSet<>((a, b) -> {
            if (a[0] == b[0]) return 0;
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        Map<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            map.put(p, l);
            set.add(new int[]{p, l});
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            String q = st.nextToken();

            if (q.charAt(0) == 'r') {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    sb.append(set.last()[0]).append("\n");
                } else {
                    sb.append(set.first()[0]).append("\n");
                }
            } else if (q.charAt(0) == 'a') {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());

                map.put(p, l);
                set.add(new int[]{p, l});
            } else {
                int p = Integer.parseInt(st.nextToken());

                set.remove(new int[]{p, map.get(p)});
            }
        }

        System.out.println(sb);
    }
}
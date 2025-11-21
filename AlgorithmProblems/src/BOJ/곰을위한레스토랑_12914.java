package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 곰을위한레스토랑_12914 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>();

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int b = Integer.parseInt(st.nextToken());

            Integer c = set.higher(b - d);

            while (c != null && Math.abs(c - b) < d) {
                b = c + d;
                c = set.higher(b - d);
            }

            sb.append(b).append(" ");
            set.add(b);
        }

        System.out.println(sb);
    }
}
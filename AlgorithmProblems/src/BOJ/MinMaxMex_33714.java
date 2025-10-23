package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class MinMaxMex_33714 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        int[] cnt = new int[200001];
        TreeSet<Integer> set = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());

            set.add(a);
            if (a < 200001) cnt[a]++;
        }

        for (int i = 0; i < 200001; i++) {
            if (cnt[i] <= k) {
                System.out.println(i);
                break;
            }
        }

        for (int a : set) {
            if (a <= k) k++;
            else break;
        }

        System.out.println(k);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 시장선거포스터_2370 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] posters = new int[n][2];
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            posters[i][0] = Integer.parseInt(st.nextToken());
            posters[i][1] = Integer.parseInt(st.nextToken());

            set.add(posters[i][0]);
            set.add(posters[i][1]);
        }

        Map<Integer, Integer> map = new HashMap<>();
        int s = set.size();

        for (int i = 0; i < s; i++) {
            map.put(set.pollFirst(), i);
        }

        int[] wall = new int[s];

        for (int i = 0; i < n; i++) {
            for (int j = map.get(posters[i][0]); j <= map.get(posters[i][1]); j++) {
                wall[j] = i + 1;
            }
        }

        Set<Integer> ans = new HashSet<>();
        for (int i = 0; i < s; i++) {
            ans.add(wall[i]);
        }

        System.out.println(ans.size());
    }
}
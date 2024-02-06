package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class 요리사_4012 {
    static StringBuilder sb;
    static Map<Integer, Integer> map;
    static int n;
    static int[][] table;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");

            n =Integer.parseInt(br.readLine());

            table = new int[n][];

            arr = new int[n / 2];

            for (int i = 0; i < n; i++) {
                table[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            map = new HashMap<>();

            Set<Integer> check = new HashSet<>();

            int min = Integer.MAX_VALUE;

            int m = (1 << n) - 1;


            dfs(0, 0);

            for (int key : map.keySet()) {
                if (check.add(key)) {
                    check.add(m - key);
                    min = Math.min(min, Math.abs(map.get(key) - map.get(m - key)));
                }
            }

            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int s, int d) {
        if (d == n / 2) {

            int key = 0;
            int val = 0;

            for (int i = 0; i < n / 2; i++) {
                key += (1 << arr[i]);
            }

            for (int i = 0; i < n / 2 - 1; i++) {
                for (int j = i + 1; j < n / 2; j++) {
                    val += table[arr[i]][arr[j]] + table[arr[j]][arr[i]];
                }
            }

            map.put(key, val);

            return;
        }

        for (int i = s; i < n; i++) {
            arr[d] = i;
            dfs(i + 1, d + 1);
        }
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 거짓말_31091 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());

            if (k > 0) left[k]++;
            else right[-k]++;
        }

        for (int i = 0; i < n; i++) {
            left[i + 1] += left[i];
            right[n - i - 1] += right[n - i];
        }

        int cnt = 0;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            if (left[n] - left[i] + right[0] - right[i] == i) {
                cnt++;
                ans.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(cnt).append("\n");
        for (int i = 0; i < cnt; i++) sb.append(ans.get(i)).append(" ");

        System.out.println(sb);
    }
}
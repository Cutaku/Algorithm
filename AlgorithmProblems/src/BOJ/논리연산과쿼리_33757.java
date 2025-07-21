package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 논리연산과쿼리_33757 {
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken());

        root = new int[n];
        for (int i = 1; i < n; i++) root[i] = i;

        int[] size = new int[n];
        int[] sum = new int[n];

        boolean[] isOne = new boolean[n];

        String input = br.readLine();

        for (int i = 0; i < n; i++) {
            isOne[i] = input.charAt(2 * i) == '1';
            size[i]++;
            if (isOne[i]) sum[i]++;
        }

        int cnt = 0;

        for (int i = 0; i < n - 1; i++) {
            int j = find(i);

            if (input.charAt(2 * i + 1) == '&') {
                root[i + 1] = j;
                size[j]++;
                sum[j] += sum[i + 1];
            } else {
                if (sum[j] == size[j]) cnt++;
            }
        }

        if (sum[find(n - 1)] == size[find(n - 1)]) cnt++;

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < q; i++) {
            int k = Integer.parseInt(st.nextToken()) - 1;
            int r = find(k);

            if (isOne[k]) {
                if (--sum[r] == size[r] - 1) {
                    cnt--;
                }

                isOne[k] = false;
            } else {
                if (++sum[r] == size[r]) {
                    cnt++;
                }

                isOne[k] = true;
            }

            sb.append(cnt > 0 ? "1" : "0");
        }

        System.out.println(sb);
    }

    static int find(int a) {

        if (a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 곱하기와쿼리_28421 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] cnt = new int[10001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            cnt[arr[i]]++;
        }

        StringBuilder sb = new StringBuilder();

        a: for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            if (st.nextToken().equals("1")) {
                int x = Integer.parseInt(st.nextToken());

                if (x == 0) {
                    if (cnt[0] > 0 && n > 1) sb.append("1\n");
                    else sb.append("0\n");
                } else {
                    int r = (x + 9999) / 10000;

                    while (r * r < x) {
                        if (cnt[r] > 0 && x % r == 0 && cnt[x / r] > 0) {
                            sb.append("1\n");
                            continue a;
                        }

                        r++;
                    }

                    if (r * r == x && cnt[r] > 1) sb.append("1\n");
                    else sb.append("0\n");
                }
            } else {
                int idx = Integer.parseInt(st.nextToken()) - 1;

                cnt[arr[idx]]--;
                arr[idx] = 0;
                cnt[0]++;
            }
        }

        System.out.println(sb);
    }
}
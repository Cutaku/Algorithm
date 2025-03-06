package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 뒤집기게임_23058 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] bit = new int[(1 << (n - 1)) + 1];
        for (int i = 1; i < n; i++) bit[1 << i] = i;

        int[] board =new int[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                board[i] <<= 1;
                board[i] |= Integer.parseInt(st.nextToken());
            }
        }

        int x = (1 << n) - 1;

        int min = n * n;

        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < (1 << n); j++) {
                int[] clone = board.clone();
                int r = i, c = j;
                int cnt = 0;

                while (r > 0) {
                    cnt++;
                    int q = r & -r;
                    r -= q;

                    clone[bit[q]] ^= x;
                }

                while (c > 0) {
                    cnt++;
                    int q = c & -c;
                    c -= q;

                    for (int k = 0; k < n; k++) clone[k] ^= q;
                }

                int l = 0;
                for (int k = 0; k < n; k++) l += Integer.bitCount(clone[k]);

                cnt += Math.min(l, n * n - l);

                min = Math.min(min, cnt);
            }
        }

        System.out.println(min);
    }
}
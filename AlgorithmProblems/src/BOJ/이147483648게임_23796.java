package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이147483648게임_23796 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[][] board = new long[8][8];

        StringTokenizer st;
        for (int i = 0; i < 8; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 8; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        String d = br.readLine();

        int r, c;
        int[] a, b;

        switch (d) {
            case "L":
                r = 0;
                c = 0;
                a = new int[]{1, 0};
                b = new int[]{0, 1};
                break;
            case "U":
                r = 0;
                c = 0;
                a = new int[]{0, 1};
                b = new int[]{1, 0};
                break;
            case "R":
                r = 0;
                c = 7;
                a = new int[]{1, 0};
                b = new int[]{0, -1};
                break;
            default:
                r = 7;
                c = 0;
                a = new int[]{0, 1};
                b = new int[]{-1, 0};
        }

        for (int i = 0; i < 8; i++) {
            long[] input = new long[8];
            int sr = r, sc = c;

            for (int j = 0; j < 8; j++) {
                input[j] = board[sr][sc];
                sr += b[0];
                sc += b[1];
            }

            long[] output = compress(input);

            sr = r;
            sc = c;

            for (int j = 0; j < 8; j++) {
                board[sr][sc] = output[j];
                sr += b[0];
                sc += b[1];
            }

            r += a[0];
            c += a[1];
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sb.append(board[i][j]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static long[] compress(long[] arr) {

        long[] res = new long[8];
        int idx = 0;

        for (int i = 0; i < 8; i++) {
            if (arr[i] == 0) continue;

            if (arr[i] == res[idx]) res[idx++] <<= 1;
            else if (res[idx] == 0) res[idx] = arr[i];
            else res[++idx] = arr[i];
        }

        return res;
    }
}
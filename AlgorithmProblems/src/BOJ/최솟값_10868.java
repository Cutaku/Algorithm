package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최솟값_10868 {
    static int[] arr;
    static int[] seg;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int l = 1;
        while (l < (n << 1)) l <<= 1;

        arr = new int[n];
        seg = new int[l];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(1, 0, n - 1);

        for (int t = 0; t < m; t++) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken()) - 1, j = Integer.parseInt(st.nextToken()) - 1;

            sb.append(min(1, 0, n - 1, i, j)).append("\n");
        }

        System.out.println(sb);
    }

    static int min(int idx, int left, int right, int i, int j) {

        if (right < i || j < left) return Integer.MAX_VALUE;

        if (i <= left && right <= j) return seg[idx];

        int mid = (left + right) >> 1;
        return Math.min(min(idx << 1, left, mid, i, j), min(idx << 1 | 1, mid + 1, right, i, j));
    }

    static int init(int idx, int left, int right) {

        if (left == right) return seg[idx] = arr[left];

        int mid = (left + right) >> 1;
        return seg[idx] = Math.min(init(idx << 1, left, mid),init(idx << 1 | 1, mid + 1, right));
    }
}
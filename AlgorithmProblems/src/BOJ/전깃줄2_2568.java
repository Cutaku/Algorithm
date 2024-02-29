package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 전깃줄2_2568 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        int[] lis = new int[n];
        int[] before = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int l = 1;
        before[0] = -1;

        for (int i = 1; i < n; i++) {
            if (arr[lis[l - 1]][1] < arr[i][1]) {
                before[i] = lis[l - 1];
                lis[l++] = i;
            } else if (arr[lis[0]][1] > arr[i][1]) {
                lis[0] = i;
                before[i] = -1;
            } else {
                int s = 0;
                int e = l - 1;

                while (e - s > 1) {
                    int m = (s + e) / 2;

                    if (arr[lis[m]][1] < arr[i][1]) s = m;
                    else e = m;
                }

                lis[e] = i;
                before[i] = lis[s];
            }
        }

        boolean[] used = new boolean[n];

        int last = lis[l - 1];

        do {
            used[last] = true;
            last = before[last];
        } while (last >= 0);

        sb.append(n - l).append("\n");

        for (int i = 0; i < n; i++) {
            if (!used[i]) sb.append(arr[i][0]).append("\n");
        }

        System.out.println(sb);
    }
}
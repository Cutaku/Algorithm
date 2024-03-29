package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class HSAT_5_성적평가 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] ans = new int[n];

        int[][] arr = new int[n][2];
        int[][] total = new int[n][2];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[j][0] = j;
                arr[j][1] = Integer.parseInt(st.nextToken());
                total[j][1] += arr[j][1];
            }

            Arrays.sort(arr, Comparator.comparingInt(a -> -a[1]));

            for (int j = 0; j < n ; j++) {
                ans[arr[j][0]] = j + 1;
                if (j > 0 && arr[j][1] == arr[j - 1][1]) ans[arr[j][0]] = ans[arr[j - 1][0]];
            }

            for (int r : ans) sb.append(r).append(' ');
            sb.append("\n");
        }

        for (int i = 0; i < n; i++) total[i][0] = i;

        Arrays.sort(total, Comparator.comparingInt(a -> -a[1]));

        for (int i = 0; i < n; i++) {
            ans[total[i][0]] = i + 1;
            if (i > 0 && total[i][1] == total[i - 1][1]) ans[total[i][0]] = ans[total[i - 1][0]];
        }

        for (int r : ans) sb.append(r).append(' ');

        System.out.println(sb);
    }
}

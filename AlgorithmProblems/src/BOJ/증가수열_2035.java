package BOJ;

import java.io.*;

public class 증가수열_2035 {
    static int[] arr;
    static String s;
    static int l;
    static int[] min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[81];
        s = br.readLine();
        l = s.length();
        min = new int[]{0, l};

        dfs(0, 0);

        StringBuilder sb = new StringBuilder();

        while (s.charAt(min[0]) == '0') min[0]++;

        for (int i = min[0]; i < min[1]; i++) {
            sb.append(s.charAt(i));
        }

        System.out.println(sb);
    }

    static void dfs(int d, int idx) {

        if (idx == l) {
            if (bigger(min[0], min[1], arr[d - 1], l)) {
                min[0] = arr[d - 1];
            }
        }

        if (d == 0) {
            for (int i = idx + 1; i <= l; i++) {
                arr[d + 1] = i;
                dfs(d + 1, i);
            }
        } else {
            boolean flag = true;

            for (int i = idx + 1; i <= l; i++) {
                if (flag && bigger(arr[d - 1], arr[d], arr[d], i)) continue;
                if (bigger(arr[d], i, min[0], min[1])) return;

                flag = false;

                arr[d + 1] = i;
                dfs(d + 1, i);
            }
        }
    }

    static boolean bigger(int i1, int i2, int j1, int j2) {

        while (i1 < i2 && s.charAt(i1) == '0') i1++;
        while (j1 < j2 && s.charAt(j1) == '0') j1++;

        int l1 = i2 - i1;
        int l2 = j2 - j1;

        if (l1 > l2) return true;
        if (l1 < l2) return false;

        for (int i = 0; i < l1; i++) {
            if (s.charAt(i1 + i) > s.charAt(j1 + i)) return true;
            if (s.charAt(i1 + i) < s.charAt(j1 + i)) return false;
        }

        return true;
    }
}
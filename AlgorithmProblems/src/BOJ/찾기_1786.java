package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 찾기_1786 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        int l1 = str1.length;
        int l2 = str2.length;

        int[] p = new int[l2];

        for (int i = 1; i < l2; i++) {
            int l = p[i - 1];

            while (l > 0 && str2[l] != str2[i]) l = p[l - 1];

            p[i] = l;
            if (str2[l] == str2[i]) p[i]++;
        }

        int i = 0;
        int j = 0;

        List<Integer> start = new ArrayList<>();

        while (i + j < l1) {
            if (str1[i + j] == str2[j]) {
                j++;
                if (j == l2) {
                    start.add(i + 1);
                    i += (j - p[j - 1]);
                    j = p[j - 1];
                }
            } else if (j == 0){
              i++;
            } else {
                i += (j - p[j - 1]);
                j = p[j - 1];
            }
        }

        sb.append(start.size()).append("\n");

        for (int s : start) {
            sb.append(s).append(' ');
        }

        System.out.println(sb);
    }
}
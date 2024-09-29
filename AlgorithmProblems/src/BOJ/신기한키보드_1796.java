package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 신기한키보드_1796 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] idx = new int[26][];

        String word = br.readLine();

        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';

            if (idx[j] == null) {
                idx[j] = new int[]{i, i};
            } else {
                idx[j][0] = Math.min(idx[j][0], i);
                idx[j][1] = Math.max(idx[j][1], i);
            }
        }

        int[] min = {0, 0};
        int[] last = {0, 0};

        for (int i = 0; i < 26; i++) {
            if (idx[i] == null) continue;

            int l = Math.min(min[0] + Math.abs(last[0] - idx[i][1]), min[1] + Math.abs(last[1] - idx[i][1]));
            int r = Math.min(min[0] + Math.abs(last[0] - idx[i][0]), min[1] + Math.abs(last[1] - idx[i][0]));

            min[0] = l + Math.abs(idx[i][0] - idx[i][1]);
            min[1] = r + Math.abs(idx[i][0] - idx[i][1]);
            last = idx[i];
        }

        System.out.println(word.length() + Math.min(min[0], min[1]));
    }
}
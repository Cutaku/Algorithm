package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A와B_12904 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] word1 = br.readLine().toCharArray();
        char[] word2 = br.readLine().toCharArray();

        int l1 = word1.length;
        int l2 = word2.length;

        int l = 0, r = l2 - 1;

        boolean reversed = false;

        for (int i = 0; i < l2 - l1; i++) {
            if (reversed) {
                if (word2[l++] == 'B') reversed = false;
            } else {
                if (word2[r--] == 'B') reversed = true;
            }
        }

        if (reversed) {
            for (int i = 0; i < l1; i++) {
                if (word1[i] != word2[r - i]) {
                    System.out.println(0);
                    return;
                }
            }

            System.out.println(1);
        } else {
            for (int i = 0; i < l1; i++) {
                if (word1[i] != word2[l + i]) {
                    System.out.println(0);
                    return;
                }
            }

            System.out.println(1);
        }
    }
}
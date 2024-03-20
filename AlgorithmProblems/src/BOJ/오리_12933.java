package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오리_12933 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ducks = br.readLine().toCharArray();

        int[] counts = new int[4];

        int[] idx = new int['u' + 1];
        idx['u'] = 1;
        idx['a'] = 2;
        idx['c'] = 3;
        idx['k'] = 4;

        int size = 0;

        int max = 0;

        for (char duck : ducks) {
            if (duck == 'q') {
                size++;
                max = Math.max(max, size);
                counts[0]++;
            } else {
                if (--counts[idx[duck] - 1] < 0) {
                    System.out.println(-1);
                    return;
                }

                if (duck != 'k') counts[idx[duck]]++;
                else size--;
            }
        }

        if (size > 0) System.out.println(-1);
        else System.out.println(max);
    }
}
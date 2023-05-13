package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 대표선수_2461 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        int[][] classes = new int[n][];
        for (int i = 0; i < n; i++) classes[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int[] c : classes) {
            Arrays.sort(c);
        }

        int[] indexes = new int[n];
        int[] abilities = new int[n];
        for (int i = 0; i < n; i++) abilities[i] = classes[i][0];

        int min = 1000000000;

        while (true) {
            min = Math.min(min, findGap(abilities));

            int i = findMinIndex(abilities);

            if (indexes[i] == m - 1) break;

            abilities[i] = classes[i][++indexes[i]];
        }

        System.out.println(min);
    }

    static int findGap(int[] abilities) {

        int max = abilities[0];
        int min = abilities[0];

        for (int ability : abilities) {
            max = Math.max(max, ability);
            min = Math.min(min, ability);
        }

        return max - min;
    }

    static int findMinIndex(int[] abilities) {

        int min = abilities[0];
        int index = 0;

        for (int i = 1; i < abilities.length; i++) {
            if (min > abilities[i]) {
                min = abilities[i];
                index = i;
            }
        }

        return index;
    }
}
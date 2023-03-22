package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 퍼즐_1525 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] puzzle = new int[3][];
        for (int i = 0; i < 3; i++) {
            puzzle[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Map<String, Integer> map = new HashMap<>();

        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();

        q1.add(puzzleToString(puzzle));
        map.put(puzzleToString(puzzle),1);

        int count = 0;

        while (!q1.isEmpty()) {

            String str = q1.poll();

            if (str.equals("123456780")) {
                System.out.println(count);
                return;
            }

            if (str.length() < 9) str = "0" + str;

            int index = 0;
            while (true) {
                if (str.charAt(index) == '0') break;
                index++;
            }

            if (index%3 < 2) {
                String m = change(str, index, index + 1);
                if (!map.containsKey(m)) {
                    q2.add(m);
                    map.put(m, 1);
                }
            }

            if (index%3 > 0) {
                String m = change(str, index, index - 1);
                if (!map.containsKey(m)) {
                    q2.add(m);
                    map.put(m, 1);
                }
            }

            if (index < 6) {
                String m = change(str, index, index + 3);
                if (!map.containsKey(m)) {
                    q2.add(m);
                    map.put(m, 1);
                }
            }

            if (index > 2) {
                String m = change(str, index, index - 3);
                if (!map.containsKey(m)) {
                    q2.add(m);
                    map.put(m, 1);
                }
            }

            if (q1.isEmpty()) {
                q1 = q2;
                q2 = new LinkedList<>();
                count++;
            }
        }

        System.out.println(-1);
    }

    static String puzzleToString(int[][] puzzle) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                str.append(puzzle[i][j]);
            }
        }

        return str.toString();
    }

    static String change(String str, int n, int m) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if (i == n) result += str.charAt(m);
            else if (i == m) result += str.charAt(n);
            else result += str.charAt(i);
        }

        return result;
    }
}
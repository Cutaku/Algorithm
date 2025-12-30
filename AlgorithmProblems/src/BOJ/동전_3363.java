package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전_3363 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Test[] tests = new Test[3];
        for (int i = 0; i < 3; i++) {
            String input = br.readLine();

            while (input.isBlank()) input = br.readLine();

            tests[i] = new Test(input);
        }


        String ans = null;

        for (int i = 1; i < 13; i++) {
            if (check(i, true, tests)) {
                if (ans == null) {
                    ans = i + "+";
                } else {
                    System.out.println("indefinite");
                    return;
                }
            }

            if (check(i, false, tests)) {
                if (ans == null) {
                    ans = i + "-";
                } else {
                    System.out.println("indefinite");
                    return;
                }
            }
        }

        System.out.println(ans == null ? "impossible" : ans);
    }

    static boolean check(int c, boolean isHeavy, Test[] tests) {

        for (Test test : tests) {
            if (!test.check(c, isHeavy)) return false;
        }

        return true;
    }

    static class Test {

        int[] left = new int[4];
        int[] right = new int[4];
        int status;

        Test(String input) {
            StringTokenizer st = new StringTokenizer(input);

            for (int i = 0; i < 4; i++) {
                left[i] = Integer.parseInt(st.nextToken());
            }

            char c = st.nextToken().charAt(0);

            status = c == '<' ? 0 : (c == '>' ? 1 : 2);

            for (int i = 0; i < 4; i++) {
                right[i] = Integer.parseInt(st.nextToken());
            }
        }

        boolean check(int c, boolean isHeavy) {

            if (status == 2) {
                for (int i = 0; i < 4; i++) {
                    if (left[i] == c || right[i] == c)  return false;
                }

                return true;
            } else {
                int[] arr = (isHeavy ^ (status == 0)) ? left : right;

                for (int i = 0; i < 4; i++) {
                    if (arr[i] == c) return true;
                }

                return false;
            }
        }
    }
}
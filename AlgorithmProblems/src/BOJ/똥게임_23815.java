package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 똥게임_23815 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] max = new int[]{1, 1};

        StringTokenizer st;

        boolean flag = true;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String o1 = st.nextToken();
            String o2 = st.nextToken();

            max[1] = Math.max(order(o1.charAt(0), max[1], o1.charAt(1) - '0'),
                    order(o2.charAt(0), max[1], o2.charAt(1) - '0'));

            max[1] = Math.max(max[0], max[1]);

            if (max[1] <= 0) {
                System.out.println("ddong game");
                return;
            }

            if (flag) max[0] = Math.max(order(o1.charAt(0), max[0], o1.charAt(1) - '0'),
                    order(o2.charAt(0), max[0], o2.charAt(1) - '0'));

            if (max[0] <= 0) flag = false;
        }

        System.out.println(max[1]);
    }

    static int order(char c, int a, int b) {

        return switch (c) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            default -> a / b;
        };
    }
}
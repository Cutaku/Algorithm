package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 다항함수의적분_17214 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int[] poly = Arrays.stream(input.split("x+")).mapToInt(Integer::parseInt).toArray();

        if (poly.length == 2 || input.charAt(input.length() - 1) == 'x') {
            poly[0] >>= 1;
        }

        if (poly.length == 2) {
            System.out.println(toString(poly[0]) + "xx" + (toString(poly[1]).equals("0") ? "" : (poly[1] > 0 ? "+" : "") + toString(poly[1]) + "x") + "+W");
        } else if (input.charAt(input.length() - 1) == 'x') {
            System.out.println(toString(poly[0]) + "xx+W");
        } else {
            if (poly[0] == 0) System.out.println("W");
            else System.out.println(toString(poly[0]) + "x+W");
        }
    }

    static String toString(int a) {

        if (a == 1) return "";
        if (a == -1) return "-";
        else return a + "";
    }
}
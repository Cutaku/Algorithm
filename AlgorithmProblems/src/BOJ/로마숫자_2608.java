package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 로마숫자_2608 {
    static Map<Character, Integer> map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int a = toInt(br.readLine());
        int b = toInt(br.readLine());

        System.out.println(a + b);
        System.out.println(toRoman(a + b));
    }

    static int toInt(String roman) {

        int l = roman.length();
        int[]  arabia = new int[l];

        int res = arabia[l - 1] = map.get(roman.charAt(l - 1));

        for (int i = l - 2; i >= 0; i--) {
            arabia[i] = map.get(roman.charAt(i));
            res += arabia[i] < arabia[i + 1] ? -arabia[i] : arabia[i];
        }

        return res;
    }

    static String toRoman(int num) {

        StringBuilder res = new StringBuilder();

        while (num >= 1000) {
            res.append("M");
            num -= 1000;
        }

        if (num >= 900) {
            res.append("CM");
            num -= 900;
        }

        if (num >= 500) {
            res.append("D");
            num -= 500;
        }

        if (num >= 400) {
            res.append("CD");
            num -= 400;
        }

        while (num >= 100) {
            res.append("C");
            num -= 100;
        }

        if (num >= 90) {
            res.append("XC");
            num -= 90;
        }

        if (num >= 50) {
            res.append("L");
            num -= 50;
        }

        if (num >= 40) {
            res.append("XL");
            num -= 40;
        }

        while (num >= 10) {
            res.append("X");
            num -= 10;
        }

        if (num == 9) {
            res.append("IX");
            num -= 9;
        }

        if (num >= 5) {
            res.append("V");
            num -= 5;
        }

        if (num == 4) {
            res.append("IV");
            num -= 4;
        }

        while (num > 0) {
            res.append("I");
            num -= 1;
        }

        return res.toString();
    }
}
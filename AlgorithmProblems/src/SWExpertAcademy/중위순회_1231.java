package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 중위순회_1231 {
    static StringBuilder sb;
    static int n;
    static char[] chars;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            sb.append("#").append(tc).append(" ");

            n = Integer.parseInt(br.readLine());

            chars = new char[n + 1];

            for (int i = 1; i <= n; i++) {
                String[] node = br.readLine().split(" ");

                chars[i] = node[1].charAt(0);
            }

            inOrder(1);
            
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void inOrder(int i) {

        if (i * 2 <= n) inOrder(i * 2);
        sb.append(chars[i]);
        if (i * 2 + 1 <= n)  inOrder(i * 2 + 1);
    }

}
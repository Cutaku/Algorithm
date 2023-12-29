package SWExpertAcademy;

import java.io.*;
import java.util.Arrays;

public class 평균의평균_18799 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            bw.append("#").append(String.valueOf(t)).append(" ");

            int n = Integer.parseInt(br.readLine());

            double s = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).sum();

            double c = 1;

            double ans = 1;

            for (int i = 2; i <= n; i++) {
                c *= (n + 1 - i);
                c /= i - 1;
                ans += c / i;
            }

            ans *= s / (Math.pow(2, n) - 1);

            bw.append(toString(ans)).append("\n");
        }

        bw.flush();
    }

    public static String toString(double ans) {

        if (ans - (int) ans == 0) return String.valueOf((int) ans);
        else return String.valueOf(ans);
    }
}
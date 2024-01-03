package SWExpertAcademy;

import java.io.*;

public class 큰수의최대공약수_17937 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T= Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            bw.append("#").append(String.valueOf(tc)).append(" ");

            String[] ab = br.readLine().split(" ");
            String a = ab[0], b = ab[1];

            if (a.equals(b)) bw.append(a).append("\n");
            else bw.append('1').append("\n");
        }

        bw.flush();
    }
}
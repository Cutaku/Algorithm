package BOJ;

import java.io.*;

public class 괄호_9012 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String str = br.readLine();

            int s = 0;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') s++;
                else s--;

                if (s < 0) break;
            }

            if (s == 0) bw.append("YES\n");
            else bw.append("NO\n");
        }

        bw.flush();
    }
}
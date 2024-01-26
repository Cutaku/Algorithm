package BOJ;

import java.io.*;

public class 별찍기10_2447 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[] {"*"};

        while (n % 3 == 0) {
            arr = multi(arr);
            n /= 3;
        }

        for (String line : arr) bw.append(line).append("\n");

        bw.flush();
    }

    public static String[] multi(String[] arr) {

        int n = arr.length;

        StringBuilder sb = new StringBuilder();

        String[] result = new String[3 * n];

        for (int i = 0; i < n; i++) sb.append(" ");

        String blank = sb.toString();

        for (int i = 0; i < n; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < 3; j++) sb.append(arr[i]);

            result[i] = sb.toString();
            result[i + 2 * n] = result[i];

            sb = new StringBuilder();
            sb.append(arr[i]);
            sb.append(blank);
            sb.append(arr[i]);

            result[i + n] = sb.toString();
        }

        return result;
    }
}
package BOJ;

import java.io.*;
import java.util.Arrays;

public class 트리_4256 {
    static BufferedWriter bw;
    static int[] preOrder;
    static int[] inOrder;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            int n = Integer.parseInt(br.readLine());

            preOrder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            inOrder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            findPost(0, 0, n);

            bw.append("\n");
        }

        bw.flush();
    }

    public static void findPost(int pre, int in, int l) throws IOException {

        if (l == 0) return;

        int length = 0;

        while (inOrder[in + length] != preOrder[pre]) length++;

        findPost(pre + 1, in, length);
        findPost(pre + length + 1, in + length + 1, l - length - 1);

        bw.append(String.valueOf(preOrder[pre]));
        bw.append(" ");
    }
}
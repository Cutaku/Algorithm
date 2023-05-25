package BOJ;

import java.io.*;
import java.util.Arrays;

public class 트리의순회_2263 {
    static int[] inOrder;
    static int[] postOrder;
    static BufferedWriter bw;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        inOrder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        postOrder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        getPreOrder(0, 0, n);

        bw.flush();
    }

    public static void getPreOrder(int inStart, int postStart, int length) throws IOException {

        if (length == 0) return;

        int root = postOrder[postStart + length - 1];

        bw.append(root + " ");

        int left = 0;
        while (inOrder[inStart + left] != root) left++;

        getPreOrder(inStart, postStart, left);
        getPreOrder(inStart + left + 1, postStart + left, length - left - 1);
    }
}
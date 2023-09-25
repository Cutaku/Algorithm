package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class 최솟값찾기_11003 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nl = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nl[0], l = nl[1];

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> dq = new LinkedList<>();

        int i = 0;

        while (i < n) {
            if (!dq.isEmpty() && i - dq.peekFirst() >= l) dq.pollFirst();

            while (!dq.isEmpty() && arr[dq.peekLast()] >= arr[i]) dq.pollLast();

            dq.addLast(i++);

            bw.append(arr[dq.peekFirst()] + " ");
        }

        bw.flush();
    }
}
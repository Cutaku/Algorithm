package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class 오큰수_17298 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[i] > arr[s.peek()])  answer[s.pop()] = arr[i];
            s.add(i);
        }

        for (int ans : answer) bw.write(ans + " ");
        bw.flush();
    }
}
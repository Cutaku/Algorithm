package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class 오등큰수_17299 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] count = new int[1000001];

        for (int i = 0; i < n; i++) count[arr[i]]++;

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) ans[i] = count[arr[i]];

        Stack<Integer> stack = new Stack<>();

        int i = 0;

        while (i < n) {
            while (!stack.isEmpty() && ans[stack.peek()] < ans[i]) {
                ans[stack.pop()] = arr[i];
            }

            stack.push(i++);
        }

        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }

        for (int a : ans) bw.write(a + " ");

        bw.flush();
    }
}
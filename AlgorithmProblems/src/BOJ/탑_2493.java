package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class 탑_2493 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] towers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] answer = new int[n];

        Stack<Integer> t = new Stack<>();
        Stack<Integer> index = new Stack<>();

        t.add(100000001);
        index.add(0);

        int i = 0;

        while (i < n) {
            if (t.peek() > towers[i]) {
                answer[i] = index.peek();
                t.add(towers[i]);
                index.add(++i);
            } else {
                t.pop();
                index.pop();
            }
        }

        for (int num : answer) {
            System.out.print(num + " ");
        }
    }
}
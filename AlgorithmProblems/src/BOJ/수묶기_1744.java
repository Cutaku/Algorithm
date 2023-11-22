package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 수묶기_1744 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> positive = new PriorityQueue<>();
        PriorityQueue<Integer> nonPositive = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());

            if (a > 0) positive.add(a * -1);
            else nonPositive.add(a);
        }

        int sum = 0;

        while (positive.size() > 1) {
            int a = positive.poll() * -1;
            int b = positive.poll() * -1;

            sum += Math.max(a + b, a * b);
        }

        while (nonPositive.size() > 1) {
            sum += nonPositive.poll() * nonPositive.poll();
        }

        if (!positive.isEmpty()) sum -= positive.poll();
        if (!nonPositive.isEmpty()) sum += nonPositive.poll();

        System.out.println(sum);
    }
}
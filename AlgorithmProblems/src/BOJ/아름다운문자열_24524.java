package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 아름다운문자열_24524 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        Queue<Integer>[] queues = new Queue[26];
        for (int i = 0; i < 26; i++) queues[i] = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) queues[s.charAt(i) - 'a'].add(i);

        int cnt = 0;

        while (true) {
            int last = 0;

            for (int i = 0; i < t.length(); i++) {
                int c = t.charAt(i) - 'a';

                while (!queues[c].isEmpty() && queues[c].peek() < last) {
                    queues[c].poll();
                }

                if (queues[c].isEmpty()) {
                    System.out.println(cnt);
                    return;
                } else {
                    last = queues[c].poll();
                }
            }

            cnt++;
        }
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 중력큐28078 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int q = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        int b = 0, w = 0;
        int r = 0;

        for (int i = 0; i < q; i++) {
            String[] query = br.readLine().split(" ");

            switch (query[0]) {
                case "push":
                    if (query[1].equals("w")) {
                        dq.addFirst(0);
                        w++;
                    } else {
                        if (dq.isEmpty() || dq.peekFirst() == 0) dq.push(1);
                        else dq.addFirst(dq.pollFirst() + 1);
                        b++;
                    }
                    break;
                case "pop":
                    if (!dq.isEmpty()) {
                        int p = dq.pollLast();

                        if (p == 0) {
                            w--;
                        } else {
                            if (p > 1) dq.addLast(p - 1);
                            b--;
                        }
                    }
                    break;
                case "rotate":
                    if (query[1].equals("r")) r = (r + 1) % 4;
                    else r = (r + 3) % 4;
                    break;
                default:
                    if (query[1].equals("b")) sb.append(b).append("\n");
                    else sb.append(w).append("\n");
            }

            if (r == 1) {
                while (!dq.isEmpty() && dq.peekLast() > 0) b -= dq.pollLast();
            } else if (r == 3) {
                while (!dq.isEmpty() && dq.peekFirst() > 0) b -= dq.pollFirst();
            }
        }

        System.out.println(sb);
    }
}
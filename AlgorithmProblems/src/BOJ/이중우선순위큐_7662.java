package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class 이중우선순위큐_7662 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());

            DoublePq dpq = new DoublePq();

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());

                if (st.nextToken().equals("I")) dpq.add(Integer.parseInt(st.nextToken()));
                else dpq.delete(Integer.parseInt(st.nextToken()));
            }

            if (dpq.size == 0) sb.append("EMPTY\n");
            else {
                int min = dpq.delete(-1);
                int max;

                if (dpq.size > 0) max = dpq.delete(1);
                else max = min;

                sb.append(max).append(' ').append(min).append("\n");
            };
        }

        System.out.println(sb);
    }

    static class DoublePq {
        int size = 0;
        PriorityQueue<Integer> small = new PriorityQueue<>();
        PriorityQueue<Integer> large = new PriorityQueue<>(Comparator.reverseOrder());
        Map<Integer, Integer> count = new HashMap<>();

        void add(int n) {
            size++;
            small.add(n);
            large.add(n);
            countAdd(n);
        }

        int delete(int i) {
            if (size== 0) return -1;
            size--;

            int res;

            if (i > 0) {
                while (countDelete(res = large.poll()));
            } else {
                while (countDelete(res = small.poll()));
            }

            return res;
        }

        void countAdd(int n) {
            if (count.containsKey(n)) count.put(n, count.get(n) + 1);
            else count.put(n, 1);
        }

        boolean countDelete(int n) {
            if (count.get(n) > 0) {
                count.put(n, count.get(n) - 1);
                return false;
            }

            return true;
        }
    }
}
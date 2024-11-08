package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 종점_22867 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            pq.add(toInt(st.nextToken()) + 2);
            pq.add(toInt(st.nextToken()));
        }

        int count = 0;
        int max = 0;

        while (!pq.isEmpty()) {
            count += pq.poll() % 10 - 1;
            max = Math.max(max, count);
        }

        System.out.println(max);
    }

    static int toInt(String time) {

        String[] parseByDot = time.split("\\.");

        int res = Integer.parseInt(parseByDot[1]);

        String[] parseByColon = parseByDot[0].split(":");

        res += 1000 * Integer.parseInt(parseByColon[2]);
        res += 60000 * Integer.parseInt(parseByColon[1]);
        res += 3600000 * Integer.parseInt(parseByColon[0]);

        return 10 * res;
    }
}
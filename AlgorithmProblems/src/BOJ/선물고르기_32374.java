package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 선물고르기_32374 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        TreeSet<Integer> presents = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) presents.add(Integer.parseInt(st.nextToken()));

        PriorityQueue<Integer> boxes = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> used = new PriorityQueue<>(Comparator.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) boxes.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) used.add(Integer.parseInt(st.nextToken()));

        while (!used.isEmpty() && used.peek().equals(boxes.peek())) {
            used.poll();
            boxes.poll();
        }

        System.out.println(presents.floor(boxes.peek()));
    }
}
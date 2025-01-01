package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 신년파티_1623 {
    static int[] points;
    static Node[] nodes;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        points = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) points[i] = Integer.parseInt(st.nextToken());

        nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++)  nodes[Integer.parseInt(st.nextToken()) - 1].children.add(i);

        count(0);

        sb.append(nodes[0].p1).append(" ").append(nodes[0].p2).append("\n");

        pq = new PriorityQueue<>();

        findContainedNode(0, true);
        while (!pq.isEmpty()) sb.append(pq.poll()).append(" ");
        sb.append("-1\n");

        findContainedNode(0, false);
        while (!pq.isEmpty()) sb.append(pq.poll()).append(" ");
        sb.append("-1");

        System.out.println(sb);
    }

    static void count(int idx) {

        Node node = nodes[idx];

        node.p1 += points[idx];

        node.contains = new boolean[node.children.size()];

        for (int i = 0; i < node.children.size(); i++) {
            count(node.children.get(i));

            Node child = nodes[node.children.get(i)];

            node.p1 += child.p2;

            if (child.p1 > child.p2) {
                node.p2 += child.p1;
                node.contains[i] = true;
            } else {
                node.p2 += child.p2;
            }
        }
    }

    static void findContainedNode(int idx, boolean contain) {

        Node node = nodes[idx];

        if (contain) {
            pq.add(idx + 1);

            for (int i = 0; i < node.children.size(); i++) {
                findContainedNode(node.children.get(i), false);
            }
        } else {
            for (int i = 0; i < node.children.size(); i++) {
                findContainedNode(node.children.get(i), node.contains[i]);
            }
        }
    }

    static class Node {

        int p1 = 0;
        int p2 = 0;

        List<Integer> children = new ArrayList<>();
        boolean[] contains;
    }
}
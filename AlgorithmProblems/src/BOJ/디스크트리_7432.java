package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class 디스크트리_7432 {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Node root = new Node();

        for (int i = 0; i < n; i++) {
            String[] route = br.readLine().split("\\\\");

            Node node = root;

            for (String key : route) {
                node = node.find(key);
            }
        }

        root.print(0);

        System.out.println(sb);
    }

    static class Node {

        Map<String, Node> c =  new TreeMap<>();

        Node find(String key) {

            if (!c.containsKey(key)) c.put(key, new Node());

            return c.get(key);
        }

        void print(int d) {
            for (String key : c.keySet()) {
                for (int i = 0; i < d; i++) sb.append(" ");
                sb.append(key).append("\n");

                c.get(key).print(d + 1);
            }
        }
    }
}
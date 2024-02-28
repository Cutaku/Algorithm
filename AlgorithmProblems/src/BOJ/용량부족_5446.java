package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 용량부족_5446 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n1 = Integer.parseInt(br.readLine());

            Node root = new Node(' ');

            for (int i = 0; i < n1; i++) {
                String word = br.readLine();

                Node now = root;

                for (int j = 0; j < word.length(); j++) {
                    now = now.getNext(word.charAt(j));
                }

                now.delete = true;
            }

            int n2 = Integer.parseInt(br.readLine());

            for (int i = 0; i < n2; i++) {
                String word = br.readLine();

                Node now = root;

                for (int j = 0; j < word.length(); j++) {
                    now = now.getNext(word.charAt(j));
                }

                now.noDelete = true;
            }

            sb.append(countDelete(root)[0]).append("\n");
        }

        System.out.println(sb);
    }

    static int[] countDelete(Node node) {

        int sum = 0;

        boolean canDelete = !node.noDelete;

        for (Node next : node.next) {
            if (next == null) continue;

            int[] res = countDelete(next);

            if (res[1] > 0) canDelete = false;

            sum += res[0];
        }

        if (node.delete) sum += 1;
        if (!canDelete) return new int[]{sum, 1};
        return new int[]{Math.min(sum, 1), 0};
    }

    static class Node {
        char c;
        Node[] next = new Node['z' + 1];
        boolean delete;
        boolean noDelete;

        public Node(char c) {
            this.c = c;
        }

        Node getNext(char c) {
            if (next[c] == null) next[c] = new Node(c);

            return next[c];
        }
    }
}
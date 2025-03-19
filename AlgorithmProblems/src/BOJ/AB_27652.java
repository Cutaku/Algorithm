package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AB_27652 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node aRoot = new Node();
        Node bRoot = new Node();

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            String[] query = br.readLine().split(" ");

            if (query[0].equals("find")) {
                sb.append(count(aRoot, bRoot, query[1])).append("\n");
            } else {
                boolean isA = query[1].equals("A");
                update(isA ? aRoot : bRoot, query[2], isA, query[0].equals("add"));
            }
        }

        System.out.println(sb);
    }

    static int count(Node aRoot, Node bRoot, String word) {

        int l = word.length();
        int[] aCount = new int[l - 1];
        int[] bCount = new int[l - 1];

        Node aNode = aRoot;
        Node bNode = bRoot;

        for (int i = 0; i < l - 1; i++) {
            aNode = aNode.find(word.charAt(i));
            aCount[i] = aNode.count;

            bNode = bNode.find(word.charAt(l - 1 - i));
            bCount[l - 2 - i] = bNode.count;
        }

        int res = 0;

        for (int i = 0; i < l - 1; i++) {
            res += aCount[i] * bCount[i];
        }

        return res;
    }

    static void update(Node root, String word, boolean isA, boolean add) {

        int l = word.length();
        Node node = root;

        for (int i = 0; i < l; i++) {
            node = node.find(word.charAt(isA ? i : l - 1 - i));

            if (add) node.count++;
            else node.count--;
        }
    }

    static class Node {

        Node[] children = new Node[26];
        int count = 0;

        Node find(int c) {
            c -= 'a';

            if (children[c] == null) children[c] = new Node();
            return children[c];
        }
    }
}
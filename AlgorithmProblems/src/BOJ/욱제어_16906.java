package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 욱제어_16906 {
    static boolean fin;
    static String[] ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] lengths = new int[n][2];

        for (int i = 0; i < n; i++) {
            lengths[i][0] = i;
            lengths[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lengths, Comparator.comparingInt(l -> l[1]));

        ans = new String[n];

        Node root = new Node();

        for (int[] length : lengths) {
            fin = false;

            makeWord(0, length[1], root, new ArrayList<>(), length[0]);

            if (!fin) {
                System.out.println(-1);
                return;
            }
        }

        sb.append("1\n");

        for (String s : ans) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

    static void makeWord(int d, int l, Node node, List<Character> list, int i) {

        if (d == l) {
            node.isLeaf = true;

            StringBuilder sb = new StringBuilder();
            for (char c : list) sb.append(c);

            ans[i] = sb.toString();

            fin = true;
            return;
        }

        Node next = node.getNext(0);
        if (!next.isLeaf) {
            list.add('0');
            makeWord(d + 1, l, next, list, i);
            list.remove(d);
        }

        if (fin) return;


        next = node.getNext(1);
        if (!next.isLeaf) {
            list.add('1');
            makeWord(d + 1, l, next, list, i);
            list.remove(d);
        }
    }

    static class Node {
        boolean isLeaf = false;
        Node[] next = new Node[2];

        Node getNext(int i) {
            if (next[i] == null) {
                next[i] = new Node();
            }

            return next[i];
        }
    }
}
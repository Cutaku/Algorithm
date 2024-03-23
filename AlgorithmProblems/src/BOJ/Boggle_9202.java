package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Boggle_9202 {
    static char[][] boggle;
    static boolean[][] used;
    static TreeSet<String> set;
    static int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int w = Integer.parseInt(br.readLine());

        Node root = new Node();

        for (int i = 0; i < w; i++) {
            String word = br.readLine();

            Node node = root;

            for (int j = 0; j < word.length(); j++) {
                node = node.getNext(word.charAt(j));
            }

            node.isLast = true;
        }

        br.readLine();

        int b = Integer.parseInt(br.readLine());

        for (int i = 0; i < b; i++) {
            boggle = new char[4][];
            for (int j = 0; j < 4; j++) boggle[j] = br.readLine().toCharArray();

            used = new boolean[4][4];
            set = new TreeSet<>();

            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 4; c++) {
                    if (root.hasNext(boggle[r][c])) {
                        findWords(r, c, root.getNext(boggle[r][c]), "" + boggle[r][c]);
                    }
                }
            }

            int score = 0;
            int l = 0;
            String longest = "";

            for (String s : set) {
                score += getScore(s.length());

                if (l < s.length()) {
                    l = s.length();
                    longest = s;
                }
            }

            sb.append(score).append(' ').append(longest).append(' ').append(set.size()).append("\n");

            if (i < b - 1) br.readLine();
        }

        System.out.println(sb);
    }

    static int getScore(int l) {

        if (l < 3) return 0;
        else if (l < 5) return 1;
        else if (l < 6) return 2;
        else if (l < 7) return 3;
        else if (l < 8) return 5;
        else return 11;
    }

    static void findWords(int r, int c, Node node, String word) {

        if (node.isLast) set.add(word);

        used[r][c] = true;

        for (int[] d : D) {
            int x = r + d[0];
            int y = c + d[1];

            if (x < 0 || y < 0 || x > 3 || y > 3 || used[x][y] || !node.hasNext(boggle[x][y])) continue;

            findWords(x, y, node.getNext(boggle[x][y]), word + boggle[x][y]);
        }

        used[r][c] = false;
    }

    static class Node {
        Node[] next = new Node[26];
        boolean isLast;

        Node getNext(char c) {
            if (next[c - 'A'] == null) {
                next[c - 'A'] = new Node();
            }

            return next[c - 'A'];
        }

        boolean hasNext(char c) {
            return next[c - 'A'] != null;
        }
    }
}
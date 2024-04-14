package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 전설_19585 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());

        Node cRoot = new Node();

        for (int i = 0; i < c; i++) {
            String color = br.readLine();

            Node node = cRoot;

            for (int j = 0; j < color.length(); j++) {
                node = node.getNext(color.charAt(j));
            }

            node.isLast = true;
        }

        Set<String> names = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            names.add(name);
        }

        int q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            boolean b = false;

            String teamName = br.readLine();

            Node node = cRoot;

            for (int j = 0; j < teamName.length(); j++) {
                if (node.noNext(teamName.charAt(j))) {
                    b = true;
                    sb.append("No\n");
                    break;
                }

                node = node.getNext(teamName.charAt(j));

                if (node.isLast && names.contains(teamName.substring(j + 1))) {
                    b = true;
                    sb.append("Yes\n");
                    break;
                }
            }

            if (!b) sb.append("No\n");
        }

        System.out.println(sb);
    }

    static class Node {
        Node[] next = new Node[26];
        boolean isLast = false;

        boolean noNext(char c) {
            return next[c - 'a'] == null;
        }

        Node getNext(char c) {
            if (noNext(c)) {
                next[c - 'a'] = new Node();
            }

            return next[c - 'a'];
        }
    }
}
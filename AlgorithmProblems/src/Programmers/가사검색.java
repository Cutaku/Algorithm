package Programmers;

import java.util.*;

class 가사검색 {
    public int[] solution(String[] words, String[] queries) {

        Node front = new Node(' ');
        Node back = new Node(' ');

        for (String word : words) {
            int l = word.length();

            Node p1 = front;
            Node p2 = back;

            p1.add(l);
            p2.add(l);

            for (int i = 0; i < l; i++) {
                char f = word.charAt(i);
                char b = word.charAt(l - 1 - i);

                boolean flag1 = true;
                boolean flag2 = true;

                for (Node child : p1.children) {
                    if (child.check(f)) {
                        p1 = child;
                        p1.add(l);
                        flag1 = false;
                        break;
                    }
                }

                for (Node child : p2.children) {
                    if (child.check(b)) {
                        p2 = child;
                        p2.add(l);
                        flag2 = false;
                        break;
                    }
                }

                if (flag1) {
                    Node child = new Node(f);
                    p1.children.add(child);
                    p1 = child;
                    p1.add(l);
                }

                if (flag2) {
                    Node child = new Node(b);
                    p2.children.add(child);
                    p2 = child;
                    p2.add(l);
                }
            }
        }

        int q = queries.length;

        int[] result = new int[q];

        for (int i = 0; i < q; i++) {
            String query = queries[i];
            int l = query.length();

            Node p;

            if (query.charAt(0) != '?') p = front;
            else p = back;

            for (int j = 0; j < l; j++) {

                char c;
                if (query.charAt(0) != '?') c = query.charAt(j);
                else c = query.charAt(l - 1 - j);

                if (c == '?') {
                    if (p.count.containsKey(l)) {
                        result[i] = p.count.get(l);
                    } else {
                        result[i] = 0;
                    }
                    break;
                }

                boolean flag = false;

                for (Node child : p.children) {
                    if (child.check(c)) {
                        p = child;
                        flag = true;
                        break;
                    }
                }

                if (!flag) {
                    result[i] = 0;
                    break;
                }
            }
        }

        return result;
    }

    class Node {

        char c;
        Map<Integer, Integer> count = new HashMap<>();
        List<Node> children = new ArrayList<>();

        Node(char c) {
            this.c = c;
        }

        boolean check(char c) {
            return c == this.c;
        }

        void add(int l) {
            if (count.containsKey(l)) {
                count.put(l, count.get(l) + 1);
            } else {
                count.put(l, 1);
            }
        }
    }
}

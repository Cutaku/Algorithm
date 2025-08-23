package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class N으로만들기_17255 {
    static String n;
    static int l;
    static int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = br.readLine();
        l = n.length();

        Node root = new Node();

        for (int i = 0; i < l; i++) dfs(i, i, root.find(n.substring(i, i + 1)));

        System.out.println(ans);
    }

    static void dfs(int s, int e, Node node) {

        if (e - s == l - 1) {
            if (!node.v) {
                ans++;
                node.v = true;
            }

            return;
        }

        if (s > 0) dfs(s - 1, e, node.find(n.substring(s - 1, e + 1)));
        if (e < l - 1) dfs(s, e + 1, node.find(n.substring(s, e + 2)));
    }

    static class Node {

        Map<String, Node> next = new HashMap<>();
        boolean v = false;

        Node find(String key) {
            if (!next.containsKey(key)) next.put(key, new Node());

            return next.get(key);
        }
    }
}
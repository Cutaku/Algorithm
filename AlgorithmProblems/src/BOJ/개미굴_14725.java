package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 개미굴_14725 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Trie root = new Trie("");
        Trie last = root;

        while (n-- > 0) {
            String[] info = br.readLine().split(" ");

            int l = Integer.parseInt(info[0]);

            for (int i = 1; i <= l; i++) {
                if (!last.next.containsKey(info[i])) last.next.put(info[i], new Trie(info[i]));

                last = last.next.get(info[i]);
            }

            last = root;
        }

        findAll(root, "", sb);

        System.out.println(sb);
    }

    static void findAll(Trie trie, String base, StringBuilder sb) {

        List<String> keys = new ArrayList<>(trie.next.keySet());
        Collections.sort(keys);

        for (String key : keys) {
            sb.append(base).append(key).append("\n");
            findAll(trie.next.get(key), base + "--", sb);
        }

    }

    static class Trie {
        String food;
        Map<String, Trie> next = new HashMap<>();

        public Trie(String food) {
            this.food = food;
        }
    }
}
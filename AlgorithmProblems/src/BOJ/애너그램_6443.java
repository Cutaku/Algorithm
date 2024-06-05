package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 애너그램_6443 {
    static Set<String> set;
    static int[] left;
    static int l;
    static char[] word;
    static StringBuilder sb;
    static char[] anagram;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            word = br.readLine().toCharArray();

            Arrays.sort(word);

            makeAnagram();
        }

        System.out.println(sb);
    }

    static void makeAnagram() {

        set = new HashSet<>();
        left = new int[26];
        l = word.length;

        for (int i = 0; i < l; i++) {
            left[word[i] - 'a']++;
        }
        
        anagram = new char[l];

        dfs(0);
    }

    static void dfs(int d) {

        if (d == l) {
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < l; i++) sb2.append(anagram[i]);

            String str = sb2.toString();

            if (set.add(str)) {
                sb.append(str).append("\n");
            }

            return;
        }

        for (int i = 0; i < 26; i++) {
            if (left[i] == 0) continue;
            left[i]--;

            anagram[d] = (char)(i + 'a');

            dfs(d + 1);

            left[i]++;
        }
    }
}
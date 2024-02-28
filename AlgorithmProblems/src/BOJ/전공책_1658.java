package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 전공책_1658 {
    static int n;
    static int[] need;
    static Book[] books;
    static int min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        need = new int['Z' + 1];

        String word = br.readLine();

        for (int i = 0; i < word.length(); i++) {
            need[word.charAt(i)]++;
        }

        n = Integer.parseInt(br.readLine());

        books = new Book[n];

        for (int i = 0; i < n; i++) {
            books[i] = new Book(br.readLine().split(" "));
        }

        min = 1600000;

        dfs(0, 0);

        if (min < 1600000) System.out.println(min);
        else System.out.println(-1);
    }

    static void dfs(int d, int sum) {

        if (fin()) {
            min = Math.min(min, sum);
            return;
        }

        if (d == n) return;

        dfs(d + 1, sum);

        int[] temp = need.clone();

        for (char c : books[d].title) {
            if (need[c] > 0) need[c]--;
        }

        dfs(d + 1, sum + books[d].price);

        need = temp;
    }

    static class Book {
        int price;
        char[] title;

        public Book(String[] input) {
            this.price = Integer.parseInt(input[0]);
            this.title = input[1].toCharArray();
        }
    }

    static boolean fin() {

        for (int i = 'A'; i <= 'Z'; i++) {
            if (need[i] > 0) return false;
        }

        return true;
    }
}
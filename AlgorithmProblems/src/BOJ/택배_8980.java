package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 택배_8980 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nc[0], c = nc[1];

        int m = Integer.parseInt(br.readLine());

        int[][] posts = new int[m][];
        for (int i = 0; i < m; i++) {
            posts[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Arrays.sort(posts, (p1, p2) -> {
            if (p1[1] == p2[1]) return p2[0] - p1[0];
            else return p1[1] - p2[1];
        });

        int sum = 0;

        int[] truck = new int[n + 1];

        for (int[] post : posts) {
            sum += load(truck, post, c);
        }

        System.out.println(sum);
    }

    public static int load(int[] truck, int[] post, int c) {

        int min = post[2];

        for (int i = post[0]; i < post[1]; i++) {
            min = Math.min(min, c - truck[i]);
        }

        for (int i = post[0]; i < post[1]; i++) {
            truck[i] += min;
        }

        return min;
    }
}
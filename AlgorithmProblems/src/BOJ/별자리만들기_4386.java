package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 별자리만들기_4386 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        double[][] stars = new double[n][];
        for (int i = 0; i < n; i++) stars[i] = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        PriorityQueue<Edge> q = new PriorityQueue<>();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                q.add(new Edge(i, j, stars));
            }
        }

        int[] roots = new int[n];
        for (int i = 0; i < n; i++) roots[i] = i;

        double answer = 0;

        int count = 0;

        while (count < n - 1) {
            Edge edge = q.poll();

            int r1 = findRoot(edge.star1, roots);
            int r2 = findRoot(edge.star2, roots);

            if (r1 == r2) continue;

            if (r1 > r2) roots[r1] = r2;
            else roots[r2] = r1;

            count++;
            answer += edge.distance;
        }

        System.out.printf("%.2f", answer);
    }

    public static int findRoot(int n, int[] roots) {

        while (n > roots[n]) n = roots[n];

        return n;
    }

    public static double findDistance(double[] star1, double[] star2) {

        return Math.sqrt((star1[0] - star2[0]) * (star1[0] - star2[0]) + (star1[1] - star2[1]) * (star1[1] - star2[1]));
    }

    public static class Edge implements Comparable<Edge> {

        int star1;
        int star2;

        double distance;

        public Edge(int star1, int star2, double[][] stars) {
            this.star1 = star1;
            this.star2 = star2;
            this.distance = findDistance(stars[star1], stars[star2]);
        }

        @Override
        public int compareTo(Edge edge) {
            return Double.compare(this.distance, edge.distance);
        }
    }
}
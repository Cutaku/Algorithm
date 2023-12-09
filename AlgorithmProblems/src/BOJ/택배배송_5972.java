package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 택배배송_5972 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        boolean[] v = new boolean[n + 1];

        List<int[]>[] adj = new List[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();


        for (int i = 0; i < m; i++) {
            int[] road = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            adj[road[0]].add(new int[]{road[1], road[2]});
            adj[road[1]].add(new int[]{road[0], road[2]});
        }

        PriorityQueue<Barn> pq = new PriorityQueue<>();

        Barn[] barns = new Barn[n + 1];

        for (int i = 1; i <= n; i++) {
            Barn barn = new Barn(i);

            if (i == 1) barn.distance = 0;

            barns[i] = barn;
            pq.add(barn);
        }

        while (true) {
            Barn barn = pq.poll();

            v[barn.num] = true;

            if (barn.num == n) {
                System.out.println(barn.distance);
                return;
            }

            for (int[] a : adj[barn.num]) {
                if (v[a[0]]) continue;

                if (barns[a[0]].distance > barn.distance + a[1]) {
                    Barn newBarn = new Barn(a[0]);
                    newBarn.distance = barn.distance + a[1];

                    barns[a[0]] = newBarn;
                    pq.add(newBarn);
                }
            }
        }
    }

    public static class Barn implements Comparable<Barn>{

        int num;
        int distance = Integer.MAX_VALUE;

        public Barn(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(Barn b) {
            return this.distance - b.distance;
        }
    }
}
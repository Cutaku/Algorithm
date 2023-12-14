package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 왕위계승_5021 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        Map<String , Royalty> map = new HashMap<>();

        String king = br.readLine();

        map.put(king, new Royalty(king));

        map.get(king).r = -1;

        for (int i = 0; i < n; i++) {
            String[] names = br.readLine().split(" ");

            for (String name : names) {
                if (!map.containsKey(name)) map.put(name, new Royalty(name));
            }

            map.get(names[0]).parents.add(map.get(names[1]));
            map.get(names[0]).parents.add(map.get(names[2]));
        }

        for (Royalty royalty : map.values()) {
            setRank(royalty);
        }

        PriorityQueue<Royalty> pq = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            String name = br.readLine();

            if (map.containsKey(name)) {
                pq.add(map.get(name));
            }
        }

        System.out.println(pq.poll().name);
    }

    public static double setRank(Royalty royalty) {

        if (!royalty.checked) {
            royalty.checked = true;

            for (Royalty parent : royalty.parents) {
                royalty.r += setRank(parent);
            }

            if (!royalty.parents.isEmpty()) royalty.r /= 2;
        }

        return royalty.r;
    }

    public static class Royalty implements Comparable<Royalty>{

        String name;

        List<Royalty> parents = new ArrayList<>();

        boolean checked = false;

        double r;

        public Royalty(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Royalty royalty) {
            return Double.compare(this.r, royalty.r);
        }
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 거짓말_1043 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        Node[] people = new Node[n + 1];
        for (int i = 0; i <= n; i++) people[i] = new Node(false, i);

        Node[] parties = new Node[m + 1];
        for (int i = 0; i <= m; i++) parties[i] = new Node(true, i);

        Queue<Node> q = new LinkedList<>();

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 1; i <= arr[0]; i++) {
            q.add(people[arr[i]]);
            people[arr[i]].checked = true;
        }

        for (int i = 1; i <= m; i++) {
            int[] party = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 1; j <= party[0]; j++) {
                parties[i].to.add(people[party[j]]);
                people[party[j]].to.add(parties[i]);
            }
        }

        int count = m;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (Node next : now.to) {
                if (next.checked) continue;

                next.checked = true;

                if (next.isParty) count--;

                q.add(next);
            }
        }

        System.out.println(count);
    }

    public static class Node {
        boolean isParty = false;
        int num = 0;
        boolean checked = false;
        List<Node> to = new ArrayList<>();

        public Node(boolean isParty, int num) {
            this.isParty = isParty;
            this.num = num;
        }
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 소수경로_1963 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] prime = new boolean[10000];
        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i < 10000; i++) {
            if (!prime[i]) continue;

            for (int j = 2; i * j < 10000 ; j++) {
                prime[i * j] = false;
            }
        }

        List<Integer> primes = new ArrayList<>();

        for (int i = 1000; i < 10000; i++) {
            if (prime[i]) primes.add(i);
        }

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int[] fromTo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int from = fromTo[0], to = fromTo[1];

            boolean[] visited = new boolean[10000];

            Queue<Integer> q1 = new LinkedList<>();
            Queue<Integer> q2 = new LinkedList<>();

            q1.add(from);
            visited[from] = true;

            int count = 0;

            boolean pos = false;

            while (!q1.isEmpty()) {
                int now = q1.poll();

                if (now == to) {
                    pos  = true;
                    break;
                }

                for (int p : primes) {
                    if (visited[p]) continue;

                    if (transfer(now, p)) {
                        q2.add(p);
                        visited[p] = true;
                    }
                }

                if (q1.isEmpty()) {
                    q1 = q2;
                    q2 = new LinkedList<>();
                    count++;
                }
            }

            if (pos) System.out.println(count);
            else System.out.println(0);
        }
    }

    public static boolean transfer(int n, int m) {

        char[] N = String.valueOf(n).toCharArray();
        char[] M = String.valueOf(m).toCharArray();

        int count = 0;

        for (int i = 0; i < 4; i++) {
            if (N[i] != M[i]) count++;
        }

        return (count == 1);
    }
}
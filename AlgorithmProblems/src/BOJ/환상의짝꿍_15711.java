package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 환상의짝꿍_15711 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[2000001];
        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i <= 2000000; i++) {
            if (!prime[i]) continue;

            for (int j = 2; i * j <= 2000000 ; j++) {
                prime[i * j] = false;
            }
        }

        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= 2000000; i++) {
            if (prime[i]) primes.add(i);
        }

        for (int t = 0; t < T; t++) {
            long[] ab = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            long s = ab[0] + ab[1];

            if (s < 4) {
                bw.append("NO\n");
                continue;
            }

            if (s % 2 == 0 && s > 2) {
                bw.append("YES\n");
                continue;
            }

            boolean pos = true;

            for (int p : primes) {
                if (p > Math.sqrt(s - 2)) break;

                if ((s - 2) % p == 0) {
                    bw.append("NO\n");
                    pos = false;
                    break;
                }
            }

            if (pos) {
                bw.append("YES\n");
            }
        }

        bw.flush();
    }
}
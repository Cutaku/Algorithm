import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DSLR_9019 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int[] ab = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = ab[0];
            int b = ab[1];

            int[] check = new int[10000];
            char[] op = new char[10000];
            Arrays.fill(check, -2);

            Queue<Integer> q1 = new LinkedList<>();
            Queue<Integer> q2 = new LinkedList<>();

            q1.add(a);
            check[a] = -1;

            while (true) {
                int q = q1.poll();

                if (q == b) break;

                if (check[d(q)] == -2) {
                    q2.add(d(q));
                    check[d(q)] = q;
                    op[d(q)] = 'D';
                }

                if (check[s(q)] == -2) {
                    q2.add(s(q));
                    check[s(q)] = q;
                    op[s(q)] = 'S';
                }

                if (check[l(q)] == -2) {
                    q2.add(l(q));
                    check[l(q)] = q;
                    op[l(q)] = 'L';
                }

                if (check[r(q)] == -2) {
                    q2.add(r(q));
                    check[r(q)] = q;
                    op[r(q)] = 'R';
                }

                if (q1.isEmpty()) {
                    q1 = q2;
                    q2 = new LinkedList<>();
                }
            }

            String str = "";
            int j = b;

            while (check[j] > -1) {
                str = op[j] + str;
                j = check[j];
            }

            System.out.println(str);
        }
    }

    static int d(int n) {
        n *= 2;
        return n % 10000;
    }

    static int s(int n) {
        if (n == 0) return 9999;
        else return n-1;
    }

    static int l(int n) {
        return (10*n % 10000) + n/1000;
    }

    static int r(int n) {
        return n/10 + 1000*(n%10);
    }
}
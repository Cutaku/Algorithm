import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 미팅_코테3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nmc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nmc[0];
        int m = nmc[1];
        int c = nmc[2];

        int[][] W = new int[c][];
        for (int i = 0; i < c; i++) {
            W[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long[] table = new long[m + 1];

        for (int i = 0; i < n; i++) {
            long[] temp = new long[m + 1];

            for (int j = 0; j < m; j++) {
                temp[j + 1] = Math.max(temp[j], table[j + 1]);
                temp[j + 1] = Math.max(temp[j + 1], table[j] + W[A[i]-1][B[j]-1]);
            }

            table = temp;
        }

        System.out.println(table[m]);
    }
}
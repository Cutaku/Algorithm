package BOJ;

import java.io.*;
import java.util.Arrays;

public class 방번호_1082 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] prices = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int cost = Integer.parseInt(br.readLine());

        int x = 0;
        int y = 1;

        for (int i = 1; i < n; i++) {
            if (prices[x] >= prices[i]) x = i;
            if (prices[y] >= prices[i]) y = i;
        }

        if (n == 1 || cost < prices[y]) {
            System.out.println(0);
            return;
        }

        int length = 1;
        cost -= prices[y];

        while (cost >= prices[x]) {
            length++;
            cost -= prices[x];
        }

        for (int i = n - 1; i >= 0; i--) {
            if (cost >= prices[i] - prices[y]) {
                cost -= prices[i] - prices[y];
                bw.append(String.valueOf(i));
                break;
            }
        }

        for (int i = 1; i < length; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (cost >= prices[j] - prices[x]) {
                    cost -= prices[j] - prices[x];
                    bw.append(String.valueOf(j));
                    break;
                }
            }
        }

        bw.flush();
    }
}
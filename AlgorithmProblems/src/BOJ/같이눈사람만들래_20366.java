package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 같이눈사람만들래_20366 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] snows = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(snows);

        int min = 2000000000;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int snowMan1 = snows[i] + snows[j];

                int a = 0;
                int b = n - 1;

                while (a < b) {
                    if (a == i || a == j) {
                        a++;
                        continue;
                    }

                    if (b == i || b == j) {
                        b--;
                        continue;
                    }

                    int snowMan2 = snows[a] + snows[b];

                    min = Math.min(min, Math.abs(snowMan1 - snowMan2));

                    if (snowMan1 > snowMan2 ) {
                        a++;
                    } else if (snowMan1 < snowMan2) {
                        b--;
                    } else  {
                        break;
                    }
                }
            }
        }

        System.out.println(min);
    }
}
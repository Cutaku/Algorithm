package BOJ;

import java.io.*;
import java.util.Arrays;

public class 정사면체_1930 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());

        for (int k = 0; k < K; k++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Tetra[] tetras = new Tetra[4];

            tetras[0] = new Tetra(input[0], input[1], input[2], input[3]);
            tetras[1] = new Tetra(input[1], input[2], input[0], input[3]);
            tetras[2] = new Tetra(input[2], input[3], input[0], input[1]);
            tetras[3] = new Tetra(input[3], input[0], input[2], input[1]);

            Tetra tetra = new Tetra(input[4], input[5], input[6], input[7]);


            boolean same = false;

            for (Tetra t : tetras) {
                for (int i = 0; i < 3; i++) {
                    if (t.isSame(tetra)) {
                        same = true;

                        bw.append("1\n");

                        break;
                    }

                    t.rotate();
                }

                if (same) break;
            }

            if (!same) bw.append("0\n");
        }

        bw.flush();
    }

    public static class Tetra {

        int base;
        int front;
        int left;
        int right;

        public Tetra(int base, int front, int left, int right) {
            this.base = base;
            this.front = front;
            this.left = left;
            this.right = right;
        }

        public boolean isSame(Tetra tetra) {
            if (this.base != tetra.base) return false;
            if (this.front != tetra.front) return false;
            if (this.left != tetra.left) return false;
            return this.right == tetra.right;
        }

        public void rotate() {
            int t = front;
            front = left;
            left = right;
            right = t;
        }
    }
}
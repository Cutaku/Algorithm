package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 낚시왕_17143 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] rcm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = rcm[0], c = rcm[1], m = rcm[2];

        Shark[][] sharks = new Shark[r][c];
        for (int i = 0; i < m; i++) {
            int[] shark = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            sharks[shark[0] - 1][shark[1] - 1] = new Shark(shark[2], shark[3], shark[4]);
        }

        int sum = 0;

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                if (sharks[j][i] != null) {
                    sum += sharks[j][i].z;

                    sharks[j][i] = null;
                    break;
                }
            }

            sharks = move(sharks);
        }

        System.out.println(sum);
    }

    static Shark[][] move(Shark[][] sharks) {

        int r = sharks.length;
        int c = sharks[0].length;

        Shark[][] result = new Shark[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (sharks[i][j] == null) continue;

                Shark shark = sharks[i][j];

                int x = i;
                int y = j;

                int m = shark.s;

                if (shark.d == 1 || shark.d == 2) m %= 2 * (r - 1);
                else m %= 2 * (c - 1);

                while (m > 0) {
                    switch (shark.d) {
                        case 1:
                            if (m >= x) {
                                m -= x;
                                x = 0;
                                shark.d = 2;
                            } else {
                                x -= m;
                                m = 0;
                            }
                            break;
                        case 2:
                            if (m >= r - 1 - x) {
                                m -= r - 1 - x;
                                x = r - 1;
                                shark.d = 1;
                            } else {
                                x += m;
                                m = 0;
                            }
                            break;
                        case 3:
                            if (m >= c - 1 - y) {
                                m -= c - 1 - y;
                                y = c - 1;
                                shark.d = 4;
                            } else {
                                y += m;
                                m = 0;
                            }
                            break;
                        default:
                            if (m >= y) {
                                m -= y;
                                y = 0;
                                shark.d = 3;
                            } else {
                                y -= m;
                                m = 0;
                            }
                            break;
                    }
                }

                if (result[x][y] == null || result[x][y].z < shark.z) result[x][y] = shark;
            }
        }

        return result;
    }

    static class Shark{

        int s;
        int d;
        int z;

        public Shark(int s, int d, int z) {
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
}
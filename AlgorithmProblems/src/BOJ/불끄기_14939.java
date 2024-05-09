package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 불끄기_14939 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] room = new int[10];

        for (int i = 0; i < 10; i++) {
            String line = br.readLine();

            for (int j = 0; j < 10; j++) {
                room[i] <<= 1;
                if (line.charAt(j) == 'O') room[i] |= 1;
            }
        }

        int[] bitToInt = new int[513];
        for (int i = 0; i < 10; i++) bitToInt[1 << i] = i;

        int min = 101;

        for (int i = 0; i < 1024; i++) {
            int[] temp = room.clone();

            int count = Integer.bitCount(i);

            int p = i;

            while (p > 0) {
                int b = p & -p;
                p -= b;

                turn(0, bitToInt[b], room);
            }

            for (int j = 0; j < 9; j++) {
                count += Integer.bitCount(room[j]);

                while (room[j] > 0) {
                    int b = room[j] & -room[j];

                    turn(j + 1, bitToInt[b], room);
                }
            }

            if (room[9] == 0) {
                min = Math.min(min, count);
            }

            room = temp;
        }

        System.out.println(min == 101 ? -1 : min);
    }

    static void turn(int i, int j, int[] room) {

        if (i > 0) room[i - 1] ^= 1 << j;
        if (j > 0) room[i] ^= 7 << (j - 1) & 1023;
        else room[i] ^= 3;
        if (i < 9) room[i + 1] ^= 1 << j;
    }
}
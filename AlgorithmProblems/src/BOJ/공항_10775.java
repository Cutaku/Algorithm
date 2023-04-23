package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 공항_10775 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();

        int[] to = new int[100001];
        for (int i = 0; i < 100001; i++) to[i] = i;

        int count = 0;

        while (true) {
            int plane = 0;

            try {
                plane = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                break;
            }

            List<Integer> list = new ArrayList<>();
            list.add(plane);

            while (plane != to[plane]) {
                plane = to[plane];
                list.add(plane);
            }

            if (plane == 0) break;

            count++;

            for (int l : list) to[l] = plane - 1;
        }

        System.out.println(count);
    }
}
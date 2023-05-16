package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 옥상정원꾸미기_6198 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long count = 0;

        Stack<Integer> buildings = new Stack<>();

        for (int b = 0; b < n; b++) {
            int building = Integer.parseInt(br.readLine());

            while (!buildings.isEmpty() && buildings.peek() <= building) {
                buildings.pop();
            }

            count += buildings.size();

            buildings.add(building);
        }

        System.out.println(count);
    }
}
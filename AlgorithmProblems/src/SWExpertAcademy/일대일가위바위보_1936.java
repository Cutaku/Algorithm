package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일대일가위바위보_1936 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] ab = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int a = ab[0], b = ab[1];

        if ((a == 1 && b == 3) || (a == 2 && b == 1) || (a == 3 && b == 2)) System.out.println('A');
        else System.out.println('B');
    }
}
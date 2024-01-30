package BOJ;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class 셀프넘버_4673 {
    public static void main(String[] args) throws IOException {

        boolean[] selfNumbers = new boolean[10001];

        IntStream.range(1, 10001)
                .map(n -> n + Arrays.stream(String.valueOf(n)
                        .split(""))
                        .mapToInt(Integer::parseInt)
                        .sum())
                .filter(n -> n <=10000)
                .forEach(n -> selfNumbers[n] = true);

        IntStream.range(1, 10001)
                .filter(n -> !selfNumbers[n])
                .forEach(System.out::println);
    }
}
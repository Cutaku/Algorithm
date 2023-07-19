package Programmers;

import java.util.*;

class 롤케이크자르기 {
    public int solution(int[] topping) {

        int n = topping.length;

        int[] countLeft = new int[n];
        int[] countRight = new int[n];

        Set<Integer> setLeft = new HashSet<>();
        Set<Integer> setRight = new HashSet<>();

        for (int i = 0; i < n; i++) {
            setLeft.add(topping[i]);
            setRight.add(topping[n - 1 - i]);

            countLeft[i] = setLeft.size();
            countRight[n - 1 - i] = setRight.size();
        }

        int ans = 0;

        for (int i = 0; i < n - 1; i++) {
            if (countLeft[i] == countRight[i + 1]) ans++;
        }

        return ans;
    }
}
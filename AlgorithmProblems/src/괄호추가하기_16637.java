import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 괄호추가하기_16637 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine()
                .replace('+', '0')
                .replace('-', '1')
                .replace('*', '2');

        int[] formula = new int[n];
        for (int i = 0; i < n; i++) formula[i] = str.charAt(i) - '0';

        System.out.println(findMax(formula));
    }

    static int findMax(int[] formula) {

        int l = formula.length;

        if (l == 1) return formula[0];
        if (l == 3) return calculate(formula[0], formula[1], formula[2]);

        int[] newFormula1 = new int[l - 2];
        int[] newFormula2 = new int[l - 4];

        for (int i = 0; i < l - 2; i++) newFormula1[i] = formula[i];
        for (int i = 0; i < l - 4; i++) newFormula2[i] = formula[i];

        int m = calculate(formula[l - 3], formula[l - 2], formula[l - 1]);

        if (m < 0 && formula[l - 4] == 2) {
            return Math.max(calculate(findMax(newFormula1), formula[l - 2], formula[l - 1]),
                    calculate(findMin(newFormula2), formula[l - 4], m));
        } else {
            return Math.max(calculate(findMax(newFormula1), formula[l - 2], formula[l - 1]),
                    calculate(findMax(newFormula2), formula[l - 4], m));
        }
    }

    static int findMin(int[] formula) {

        int l = formula.length;

        if (l == 1) return formula[0];
        if (l == 3) return calculate(formula[0], formula[1], formula[2]);

        int[] newFormula1 = new int[l - 2];
        int[] newFormula2 = new int[l - 4];

        for (int i = 0; i < l - 2; i++) newFormula1[i] = formula[i];
        for (int i = 0; i < l - 4; i++) newFormula2[i] = formula[i];

        int m = calculate(formula[l - 3], formula[l - 2], formula[l - 1]);

        if (m < 0 && formula[l - 4] == 2) {
            return Math.min(calculate(findMin(newFormula1), formula[l - 2], formula[l - 1]),
                    calculate(findMax(newFormula2), formula[l - 4], m));
        } else {
            return Math.min(calculate(findMin(newFormula1), formula[l - 2], formula[l - 1]),
                    calculate(findMin(newFormula2), formula[l - 4], m));
        }
    }

    static int calculate(int num1, int op, int num2) {

        switch (op) {
            case 0:
                return num1 + num2;
            case 1:
                return num1 - num2;
            default:
                return num1 * num2;
        }
    }
}
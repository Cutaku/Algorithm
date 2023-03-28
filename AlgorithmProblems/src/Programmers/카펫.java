package Programmers;

class 카펫 {
    public int[] solution(int brown, int yellow) {

        for (int i = 1; i * i < yellow + 1; i++) {
            if (yellow % i != 0) continue;

            int j = yellow / i;

            if (2 * i + 2 * j + 4 == brown) return new int[] {j + 2, i + 2};
        }

        return null;
    }
}
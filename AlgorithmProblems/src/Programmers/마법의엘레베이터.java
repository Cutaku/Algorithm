package Programmers;

class 마법의엘레베이터 {
    public int solution(int storey) {

        int count = 0;

        while (storey > 0) {
            int r = storey % 10;
            storey /= 10;
            int l = storey % 10;

            if (r < 5 || (r == 5 && l < 5)) {
                count += r;
            } else {
                count += 10 -r;
                storey++;
            }
        }

        return count;
    }
}
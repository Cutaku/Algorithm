package Programmers;

class 멀쩡한사각형 {
    public long solution(int w, int h) {

        long ans = 1l * w * h - w - h;

        while (h > 0) {
            int t = h;
            h = w % h;
            w = t;
        }

        return ans + w;
    }
}
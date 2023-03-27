package Programmers;

class 최소직사각형 {
    public int solution(int[][] sizes) {

        int n = sizes.length;

        int w = 0;

        for (int[] size : sizes) {
            w = Math.max(w, Math.max(size[0], size[1]));
        }

        int h = 0;

        for (int[] size : sizes) {
            h = Math.max(h, Math.min(size[0], size[1]));
        }

        return w * h;
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 거북이_8911 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int xMin = 0, xMax = 0, yMin = 0, yMax = 0;
            int x = 0, y = 0;
            int dx = 0, dy = 1;

            String order = br.readLine();

            for (int i = 0; i < order.length(); i++) {
                char o = order.charAt(i);

                int t;

                switch (o) {
                    case 'F':
                        x += dx;
                        y += dy;
                        xMin = Math.min(x, xMin);
                        xMax = Math.max(x, xMax);
                        yMin = Math.min(y, yMin);
                        yMax = Math.max(y, yMax);
                        break;
                    case 'B':
                        x -= dx;
                        y -= dy;
                        xMin = Math.min(x, xMin);
                        xMax = Math.max(x, xMax);
                        yMin = Math.min(y, yMin);
                        yMax = Math.max(y, yMax);
                        break;
                    case 'L':
                        t = dx;
                        dx = -dy;
                        dy = t;
                        break;
                    default:
                        t = dx;
                        dx = dy;
                        dy = -t;
                }
            }

            sb.append((xMax - xMin) * (yMax - yMin)).append("\n");
        }

        System.out.println(sb);
    }
}
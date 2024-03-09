import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집으로_1069 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken());

        double distance = Math.sqrt(x * x + y * y);

        if (d < t) {
            System.out.println(distance);
            return;
        }

        double ans = (int) (distance / d) * t;
        distance %= d;

        if (ans == 0) {
            ans = Math.min(distance, t + d - distance);
            ans = Math.min(ans, 2 * t);
        } else {
            if (distance < t) ans += distance;
            else ans += t;
        }

        System.out.println(ans);
    }
}
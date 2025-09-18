package BOJ;

public class 철도공사_23309 {
    public static void main(String[] args) throws Exception {

        int n = read(), m = read();

        int[] next = new int[1000001];
        int[] before = new int[1000001];

        int first = read();
        int last = first;

        for (int i = 1; i < n; i++) {
            int s = read();

            next[last] = s;
            before[s] = last;

            last = s;
        }

        next[last] = first;
        before[first] = last;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            String order = readString();

            int s = read();
            int station, t;

            switch (order) {
                case "BN":
                    t = next[s];
                    station = read();

                    sb.append(t).append("\n");

                    next[s] = station;
                    before[station] = s;
                    next[station] = t;
                    before[t] = station;

                    break;
                case "BP":
                    t = before[s];
                    station = read();

                    sb.append(t).append("\n");

                    before[s] = station;
                    next[station] = s;
                    before[station] = t;
                    next[t] = station;

                    break;
                case "CN":
                    t = next[s];

                    sb.append(t).append("\n");

                    next[s] = next[t];
                    before[next[t]] = s;

                    break;
                default:
                    t = before[s];

                    sb.append(t).append("\n");

                    before[s] = before[t];
                    next[before[t]] = s;
            }
        }

        System.out.println(sb);
    }

    static String readString() throws Exception {

        int c;
        while ((c = System.in.read()) <= 32) {
            if (c == -1) {
                return null;
            }
        }

        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char) c);
        } while ((c = System.in.read()) > 32);

        return sb.toString();
    }

    private static int read() throws Exception {

        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}
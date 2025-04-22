package BOJ;

15import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 노래_3156 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        TreeMap<Integer, Songs> songs = new TreeMap<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            st.nextToken();
            int b = Integer.parseInt(st.nextToken());

            Songs song = songs.getOrDefault(b, new Songs(b));
            songs.put(b, song);

            for (int j = 0; j < a; j++) {
                song.list.add(st.nextToken());
            }
        }

        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (Songs song : songs.values()) {
            if (set.size() + 1 == song.b) {
                for (String s : song.list) {
                    if (!set.contains(s)) {
                        sb.append(song.b).append(" ").append(s).append("\n");
                        break;
                    }
                }
            }

            set.addAll(song.list);
        }

        System.out.println(sb);
    }

    static class Songs {

        int b;
        List<String> list = new ArrayList<>();

        public Songs(int b) {
            this.b = b;
        }
    }
}
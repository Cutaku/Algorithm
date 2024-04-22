package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 가장높은탑쌓기_2655 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] boxes = new int[n][4];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) boxes[i][j] = Integer.parseInt(st.nextToken());
            boxes[i][3] = i;
        }

        Arrays.sort(boxes, Comparator.comparingInt(b -> b[2]));

        Map<Integer, Data> map = new HashMap<>();
        map.put(0,  new Data(0));

        for (int i = 0; i < n; i++) {
            int[] box = boxes[i];

            int max = 0;
            int mKey = 0;

            for (int key : map.keySet()) {
                if (key > box[0]) continue;


                if (map.get(key).height > max) {
                    max = map.get(key).height;
                    mKey = key;
                }
            }

            Data d = map.get(mKey);

            Data nd = new Data(d.height + box[1], d.history);
            nd.history.add(box[3]);

            map.put(box[0], nd);
        }

        int max = 0;
        int mKey = 0;

        for (int key : map.keySet()) {
            if (map.get(key).height > max) {
                max = map.get(key).height;
                mKey = key;
            }
        }

        List<Integer> maxList = map.get(mKey).history;

        sb.append(maxList.size()).append("\n");

        for (int i = 0; i < maxList.size(); i++) {
            sb.append(maxList.get(i) + 1).append("\n");
        }

        System.out.println(sb);

    }

    static class Data {
        int height;
        List<Integer> history = new ArrayList<>();

        public Data(int height, List<Integer> history) {
            this.height = height;
            this.history.addAll(history);
        }

        public Data(int height) {
            this.height = height;
        }
    }
}

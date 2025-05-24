package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 폴더정리_small_22860 {
    static Map<String, Folder> folders;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        folders = new HashMap<>();

        String[] queries = new String[n + m];
        for (int i = 0; i < n + m; i++) queries[i] = br.readLine();

        Arrays.sort(queries, (a, b) -> Integer.compare(b.charAt(b.length() - 1), a.charAt(a.length() - 1)));

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(queries[i]);

            Folder folder = getFolder(st.nextToken());
            String name = st.nextToken();

            if (st.nextToken().charAt(0) == '1') {
                Folder newFolder = getFolder(name);

                newFolder.parent = folder;

                folders.put(name, newFolder);
            } else {
                while (folder != null) {
                    folder.fileCount++;
                    folder.distinct.add(name);

                    folder = folder.parent;
                }
            }
        }

        int q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            String path = br.readLine();
            String name = path.substring(path.lastIndexOf('/') + 1);

            Folder folder = folders.get(name);

            sb.append(folder.distinct.size()).append(" ").append(folder.fileCount).append("\n");
        }

        System.out.println(sb);
    }

    static Folder getFolder(String name) {

        if (!folders.containsKey(name)) folders.put(name, new Folder());
        return folders.get(name);
    }

    static class Folder {

        int fileCount = 0;
        Set<String> distinct = new HashSet<>();
        Folder parent;
    }
}
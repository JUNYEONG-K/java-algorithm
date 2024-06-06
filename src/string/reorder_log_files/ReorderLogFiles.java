package string.reorder_log_files;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReorderLogFiles {
    static String[] reorderLogFiles(String[] logs) {
        List<String> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();

        for (String log : logs) {
            if (Character.isDigit(log.split(" ")[1].charAt(0))) digitList.add(log);
            if (Character.isLetter(log.split(" ")[1].charAt(0))) letterList.add(log);
        }

        letterList.sort((s1, s2) -> {
            String[] s1x = s1.split(" ", 2);
            System.out.println("s1x = " + Arrays.toString(s1x));
            String[] s2x = s2.split(" ", 2);

            int compared = s1x[1].compareTo(s2x[1]);
            return compared != 0 ? compared : s1x[0].compareTo(s2x[0]);
        });

        letterList.addAll(digitList);

        return letterList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] logFiles = {"id1 8 1 5 1", "id2 art can", "id3 3 6", "id4 own kit dig", "id5 art zero"};
        System.out.println("logFiles = " + Arrays.toString(logFiles));

        String[] reorderedLogFiles = reorderLogFiles(logFiles);
        System.out.println("reorderedLogFiles = " + Arrays.toString(reorderedLogFiles));
    }
}

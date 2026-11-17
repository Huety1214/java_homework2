import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;

/**
 * 範例 2：java.io — 文字檔字數統計
 * 使用類別：File、BufferedWriter、BufferedReader、InputStreamReader、OutputStreamWriter、
 *           FileInputStream、FileOutputStream、PrintWriter、IOException
 * 重點：try-with-resources 自動關閉串流；指定 UTF-8 避免中文亂碼。
 */
public class WordCounter {

    static void writeSample(File file) throws IOException {
        try (BufferedWriter w = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
            w.write("Java is fun and Java is powerful");
            w.newLine();
            w.write("Kotlin is concise and Kotlin runs on the JVM");
            w.newLine();
            w.write("I/O streams in Java are flexible");
        }
    }

    static Map<String, Integer> count(File file) throws IOException {
        Map<String, Integer> counts = new TreeMap<>();
        try (BufferedReader r = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = r.readLine()) != null) {
                for (String word : line.toLowerCase().split("[^a-z/]+")) {
                    if (!word.isEmpty()) counts.merge(word, 1, Integer::sum);
                }
            }
        }
        return counts;
    }

    static void writeReport(File out, Map<String, Integer> counts) throws IOException {
        try (PrintWriter pw = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream(out), StandardCharsets.UTF_8))) {
            pw.println("單字,次數");
            counts.forEach((k, v) -> pw.println(k + "," + v));
        }
    }

    public static void main(String[] args) {
        File input = new File(args.length > 0 ? args[0] : "sample.txt");
        File output = new File("word_count.csv");
        try {
            if (!input.exists()) writeSample(input);
            Map<String, Integer> counts = count(input);
            writeReport(output, counts);
            System.out.println("讀取：" + input.getAbsolutePath() + "（" + input.length() + " bytes）");
            counts.forEach((k, v) -> System.out.printf("%-10s %d%n", k, v));
            System.out.println("結果已寫入：" + output.getName());
        } catch (IOException e) {
            System.err.println("檔案讀寫失敗：" + e.getMessage());
        }
    }
}

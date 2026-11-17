import java.util.*;
import java.util.stream.Collectors;

/**
 * 範例 1：java.util — 成績管理
 * 使用類別：ArrayList、HashMap、TreeMap、Comparator、Optional、IntSummaryStatistics
 */
public class GradeBook {

    // Java 16+ record：自動產生建構子、getter、equals、toString
    record Student(String id, String name, int score) {
        String level() {
            if (score >= 90) return "A";
            if (score >= 80) return "B";
            if (score >= 70) return "C";
            if (score >= 60) return "D";
            return "F";
        }
    }

    private final List<Student> students = new ArrayList<>();
    private final Map<String, Student> byId = new HashMap<>();

    void add(String id, String name, int score) {
        if (score < 0 || score > 100) throw new IllegalArgumentException("分數需在 0~100：" + score);
        Student s = new Student(id, name, score);
        students.add(s);
        byId.put(id, s);
    }

    Optional<Student> find(String id) { return Optional.ofNullable(byId.get(id)); }

    List<Student> ranking() {
        List<Student> copy = new ArrayList<>(students);
        copy.sort(Comparator.comparingInt(Student::score).reversed().thenComparing(Student::id));
        return copy;
    }

    // TreeMap 讓等第依字母排序
    Map<String, List<String>> groupByLevel() {
        return students.stream().collect(Collectors.groupingBy(
                Student::level, TreeMap::new,
                Collectors.mapping(Student::name, Collectors.toList())));
    }

    IntSummaryStatistics stats() {
        return students.stream().mapToInt(Student::score).summaryStatistics();
    }

    public static void main(String[] args) {
        GradeBook book = new GradeBook();
        book.add("S001", "王小明", 88);
        book.add("S002", "林小華", 95);
        book.add("S003", "陳大文", 72);
        book.add("S004", "張美玲", 59);
        book.add("S005", "李志強", 81);

        System.out.println("=== 排名 ===");
        List<Student> rank = book.ranking();
        for (int i = 0; i < rank.size(); i++) {
            Student s = rank.get(i);
            System.out.printf("%d. %s %s %d (%s)%n", i + 1, s.id(), s.name(), s.score(), s.level());
        }

        System.out.println("=== 等第分組 ===");
        book.groupByLevel().forEach((lv, names) -> System.out.println(lv + "：" + names));

        IntSummaryStatistics st = book.stats();
        System.out.printf("=== 統計 === 平均 %.2f，最高 %d，最低 %d，人數 %d%n",
                st.getAverage(), st.getMax(), st.getMin(), st.getCount());

        System.out.println("查詢 S003：" + book.find("S003").map(Student::name).orElse("查無此人"));
        System.out.println("查詢 S999：" + book.find("S999").map(Student::name).orElse("查無此人"));
    }
}

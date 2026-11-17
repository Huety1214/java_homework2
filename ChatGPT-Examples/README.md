# Java HW3 第 4 題：使用 ChatGPT 寫出的三個範例程式

| 程式 | 使用的套件 | 主要類別 | 功能 |
|---|---|---|---|
| `GradeBook.java` | java.util | ArrayList、HashMap、TreeMap、Comparator、Optional、IntSummaryStatistics | 成績排名、等第分組、平均/最高/最低、依學號查詢 |
| `WordCounter.java` | java.io | File、BufferedReader/Writer、InputStreamReader、OutputStreamWriter、PrintWriter | 讀取文字檔統計單字次數，結果輸出成 CSV |
| `EchoChat.java` | java.net | ServerSocket、Socket、InetAddress、SocketTimeoutException | 本機 TCP 伺服器與客戶端，伺服器回傳大寫訊息 |

## 執行方式
```bash
javac -encoding UTF-8 -d out src/*.java
java -cp out GradeBook
java -cp out WordCounter          # 沒有 sample.txt 時會自動建立
java -cp out EchoChat
```
需 JDK 16 以上（GradeBook 使用 `record`）。

## 執行結果（節錄）
```
=== 排名 ===
1. S002 林小華 95 (A)
2. S001 王小明 88 (B)
...
=== 統計 === 平均 79.00，最高 95，最低 59，人數 5

java       3
is         3
kotlin     2
...

[Client] 送出：hello  ->  收到：ECHO: HELLO
[Client] 送出：bye  ->  收到：BYE
```

## 與 ChatGPT 詢問的 3 個問題（參考，請實際詢問後貼上截圖）
1. **「Java 的 try-with-resources 跟手動 close() 有什麼差別？」**
   重點：實作 `AutoCloseable` 的資源在區塊結束時自動關閉，就算拋出例外也會關；多個資源依宣告的相反順序關閉。
2. **「HashMap、TreeMap、LinkedHashMap 什麼時候用哪個？」**
   重點：HashMap 查詢最快但無順序；TreeMap 依 key 排序（O(log n)）；LinkedHashMap 保留插入順序。WordCounter 用 TreeMap 讓輸出依字母排序。
3. **「ServerSocket.accept() 會阻塞，要怎麼同時服務多個客戶端？」**
   重點：每個連線交給一條 Thread，或用 `ExecutorService` 執行緒池；大量連線可改用 `java.nio` 的 Selector。

## 優化程式碼心得
- 用 `record` 定義 Student，一行取代建構子、getter、toString。
- `Map.merge(word, 1, Integer::sum)` 取代「先 get 判斷 null 再 put」。
- `Optional` 讓「查無此人」的情況一定要被處理，避免 NullPointerException。
- 讀寫檔案指定 `StandardCharsets.UTF_8`，Windows 上中文不會亂碼。
- ServerSocket 用 port 0 讓系統自動選可用埠，避免埠號衝突。

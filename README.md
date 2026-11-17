# Java Homework HW3 報告（CH3、CH4、CH5、ChatGPT 範例）

> 繳交檔名：`113360122_林彥廷.pdf`

## 一、讀書會
| 項目 | 內容 |
|---|---|
| 組員 | （填寫） |
| 討論時間 | （填寫） |
| 地點 / Google Meet | （填寫） |
| 照片 / 截圖 | （貼上） |

## 二、GitHub
- 程式連結：`https://github.com/Huety1214/java_homework2`
- GitHub 截圖：（貼上）

## 三、程式清單

**第 1 題 CH3**：與 HW2 相同的 26 頁，程式放在 `CH3/`（清單見 Java-HW2/REPORT.md）。

**第 2 題 CH4 繼承與介面**（`CH4/`）

| 投影片 | 範例 | 主題 |
|---|---|---|
| P4、P5 | Sample4_1 | 類別的繼承（extends） |
| P6、P7 | Sample4_2 | super() 呼叫父類別建構式 |
| P9、P10 | Sample4_3 | protected 保護成員 |
| P11、P12 | Sample4_4 | 覆寫（Overriding） |
| P14、P15 | Sample4_5 | 父類別變數操作子類別物件 |
| P17、P18 | Sample4_6 | 多型（polymorphism） |
| P24 | Sample4_7 | Object.toString() |
| P25 | Sample4_8 | Object.equals() |
| P26、P27 | Sample4_9 | Object.getClass() |
| P29、P30 | Sample4_10 | 抽象類別 |
| P32、P33 | Sample4_11 | instanceof |
| P38、P39 | Sample4_12 | 介面 |
| P41、P42 | Sample4_13 | 實作多個介面（多重繼承） |

**第 3 題 CH5 大型程式、例外、I/O、執行緒**（`CH5/`，資料夾名稱 = 投影片頁碼_範例名稱）

| 投影片 | 範例 | 主題 |
|---|---|---|
| P6 | P06_Sample5_1 | 分割檔案（Sample5_1.java + Car.java） |
| P8 | P08_Sample5_2 | package pa |
| P10 | P10_Sample5_3 | 使用其他套件 pc.Car |
| P14 | P14_Sample5_4 | import |
| P19 | P19_Sample5_1 | 發生例外 |
| P21 | P21_Sample5_2 | try ~ catch |
| P24 | P24_Sample5_3 | finally |
| P26 | P26_Sample5_4 | 輸出例外的種類 |
| P30、P31 | P30_Sample5_5 | 自訂例外 throw（try ~ catch 處理） |
| P32 | P32_Sample5_5 | throws 交給呼叫者 |
| P34 | P34_Sample5_6 | 鍵盤輸入 |
| P35 | P35_Sample5_7 | 寫入檔案 test1.txt |
| P36 | P36_Sample5_8 | 讀取 test1.txt（先執行 Sample5_7） |
| P40 | P40_Sample5_9 | 命令列引數讀檔（`java Sample5_9 test3.txt`） |
| P44 | P44_Sample6_1 | 啟動執行緒 |
| P45 | P45_Sample6_2 | 多個執行緒 |
| P46 | P46_Sample6_3 | sleep |
| P47 | P47_Sample6_4 | 主執行緒 sleep |
| P48 | P48_Sample6_5 | join |
| P50 | P50_Sample6_6 | Runnable 介面 |
| P52 | P52_Sample6_7 | 未同步化的錯誤（金額算錯） |
| P55 | P55_Sample6_8 | synchronized |

套件範例的執行方式（以 P14 為例）：
```bash
cd CH5/P14_Sample5_4
javac -encoding UTF-8 -d out pb/Sample5_4.java pc/Car.java
java -cp out pb.Sample5_4
```

**第 4 題 ChatGPT 範例程式**：`ChatGPT-Examples/`（java.util、java.io、java.net），說明見該資料夾的 README.md。

> 備註：投影片 CH5 P6~P14 的 `Car.show()` 把「汽油量」印成 `num`，程式中已修正為 `gas`。

## 四、與 ChatGPT 詢問的 3 個問題（參考，請實際詢問後貼上截圖）
1. **「抽象類別和介面有什麼差別？什麼時候用哪一個？」**
   抽象類別可以有欄位和已實作的方法，但只能單一繼承；介面（Java 8 前）只有常數與抽象方法，一個類別可以實作多個介面。描述「是一種」用抽象類別，描述「具備某能力」用介面。
2. **「為什麼 Sample6_7 兩個駕駛各匯入 150 元，合計卻不是 300？」**
   `add()` 先讀 sum、再加、再寫回，兩個執行緒交錯執行時會用到舊的 sum（race condition）。加上 `synchronized` 讓同一時間只有一個執行緒進入 `add()`。
3. **「檢查例外（checked）與非檢查例外（unchecked）有什麼不同？」**
   繼承 `Exception` 的 `CarException`、`IOException` 是檢查例外，編譯器要求一定要 try~catch 或 throws；`ArrayIndexOutOfBoundsException` 繼承 `RuntimeException`，不強制處理。

## 五、優化程式碼心得（使用新的類別）
- **try-with-resources**：Sample5_7、5_8、5_9 都要手動 `close()`，而且發生例外時不會關閉。改寫成：
  ```java
  try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
      String str;
      while ((str = br.readLine()) != null) System.out.println(str);
  }
  ```
- **java.nio.file.Files**（新的類別）：讀寫整個檔案可以一行完成：
  `Files.write(Path.of("test1.txt"), List.of("Hello!", "GoodBye!"));`
  `Files.readAllLines(Path.of("test1.txt")).forEach(System.out::println);`
- **ExecutorService**（新的類別）：取代自己 `new Thread()`，用執行緒池管理：
  ```java
  ExecutorService pool = Executors.newFixedThreadPool(2);
  pool.submit(new Car("1號車"));
  pool.shutdown();
  ```
- **AtomicInteger**（新的類別）：Sample6_8 的金額累加可以改成 `AtomicInteger.addAndGet(a)`，不用 synchronized 也不會算錯。
- **@Override 標註**：覆寫方法時加上 `@Override`，方法名稱打錯時編譯器會報錯（程式中都已加上）。
- **Lambda 取代 Runnable 類別**：`new Thread(() -> System.out.println("正在進行一號車的處理")).start();`
- **自訂例外訊息**：`CarException` 可以加上建構式 `super("汽油量不能小於 0：" + g)`，例外訊息更清楚。

## 六、心得
（依自己的感想修改）CH4 讓我理解繼承與多型：同樣呼叫 `show()`，實際執行哪一個由物件的類別決定，用父類別陣列就能統一管理不同種類的車。CH5 的例外處理讓程式出錯時不會直接中止；執行緒的部分，Sample6_7 實際跑出錯誤的金額，再加上 synchronized 修正，才真正體會到多執行緒同步的重要。

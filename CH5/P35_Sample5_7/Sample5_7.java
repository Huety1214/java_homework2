// 投影片 CH5 P35：將資料寫入到檔案
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Sample5_7
{
    public static void main(String[] args)
    {
        try
        {
            FileWriter fw = new FileWriter("test1.txt");                 // 指定檔案名稱
            PrintWriter pw = new PrintWriter(new BufferedWriter(fw));   // 透過緩衝區輸出資料

            pw.println("Hello!");      // 一行一行輸出資料
            pw.println("GoodBye!");

            pw.close();                // 關閉檔案

            System.out.println("資料已經寫入檔案了");
        }

        catch (IOException e)
        {
            System.out.println("輸出入錯誤");
        }
    }
}

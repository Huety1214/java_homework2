// 投影片 CH5 P34：鍵盤輸入（BufferedReader）
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Sample5_6
{
    public static void main(String[] args)
    {
        System.out.println("請輸入字串");

        try
        {
            // 指定標準輸入並建立文字串流，透過緩衝區來讀入
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str = br.readLine();   // 從緩衝區讀取一行資料

            System.out.println("已輸入字串" + str);
        }

        catch (IOException e)
        {
            System.out.println("輸入輸出有誤");
        }
    }
}

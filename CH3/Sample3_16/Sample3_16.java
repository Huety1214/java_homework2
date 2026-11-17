// 投影片 CH3 P34：類別庫
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample3_16
{
    public static void main(String[] args) throws IOException
    {
        // System、BufferedReader、InputStreamReader、String、Integer、IOException
        // 都是類別庫所提供的類別
        System.out.println("請輸入一個整數");

        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int num = Integer.parseInt(str);

        System.out.println("您輸入的數字是:" + num);
    }
}

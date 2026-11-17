// 投影片 CH5 P50：實作 Runnable 介面
class Sample6_6
{
    public static void main(String[] args)
    {
        Car car1 = new Car("一號車");

        Thread th1 = new Thread(car1);   // 建立 Thread 類別的物件
        th1.start();                     // 啟動執行緒

        for (int i = 0; i < 5; i++)
        {
            System.out.println("正在進行main()的處理工作");
        }
    }
}

class Car implements Runnable   // 實作 Runnable 介面
{
    private String name;

    public Car(String nm)
    {
        name = nm;
    }

    // 覆寫 run 方法
    @Override
    public void run()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("正在進行" + name + "的處理");
        }
    }
}

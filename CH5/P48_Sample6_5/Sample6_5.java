// 投影片 CH5 P48：等待執行緒處理完畢 join
class Sample6_5
{
    public static void main(String[] args)
    {
        Car car1 = new Car("1號車");
        car1.start();

        try
        {
            car1.join();     // 中斷現在的執行緒，直到 car1 執行緒處理完才繼續執行
        }

        catch (InterruptedException e)
        {

        }

        System.out.println("結束main()的處理工作。");
    }
}

class Car extends Thread    // 延伸 Thread 類別
{
    private String name;

    public Car(String nm)
    {
        name = nm;
    }

    // 覆寫 run 方法，想要在其他執行緒執行的程式需寫在此方法
    @Override
    public void run()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("正在進行" + name + "的處理工作。");
        }
    }
}

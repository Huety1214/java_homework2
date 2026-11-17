// 投影片 CH5 P47：暫時停止主執行緒（main thread）
class Sample6_4
{
    public static void main(String[] args)
    {
        Car car1 = new Car("1號車");
        car1.start();

        for (int i = 0; i < 5; i++)
        {
            try
            {
                Thread.sleep(1000);   // 讓主執行緒小睡 1 秒
                System.out.println("正在進行main()的處理工作");
            }
            catch (InterruptedException e)
            {
            }
        }
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
            System.out.println("正在進行" + name + "的處理工作");
        }
    }
}

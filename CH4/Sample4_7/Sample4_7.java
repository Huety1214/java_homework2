// 投影片 CH4 P24：Object 類別的 toString()
public class Sample4_7
{
    public static void main(String[] args)
    {
        Car car1;
        car1 = new Car();

        car1.setCar(1234, 20.5);
        System.out.println(car1);    // 會自動呼叫 toString()
    }
}

class Car
{
    protected int num;
    protected double gas;

    public Car()
    {
        num = 0;
        gas = 0.0;
        System.out.println("生產了車子");
    }

    public void setCar(int n, double g)
    {
        num = n;
        gas = g;
        System.out.println("將車號設為" + num + "，汽油量設為" + gas);
    }

    // 覆寫 Object 類別的 toString 方法（不覆寫的話會印出 Car@十六進位雜湊碼）
    @Override
    public String toString()
    {
        String str = "車號:" + num + "汽車量:" + gas;
        return str;
    }
}

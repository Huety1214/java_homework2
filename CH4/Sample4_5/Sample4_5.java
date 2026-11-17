// 投影片 CH4 P14、P15：以父類別變數操作子類別物件
public class Sample4_5
{
    public static void main(String[] args)
    {
        Car car1;
        car1 = new RacingCar();   // 父類別的變數指向子類別的物件

        car1.setCar(1234, 20.5);
        // car1.setCourse(5);     // 無法呼叫：Car 型別的變數只能使用 Car 擁有的方法

        car1.show();              // 呼叫的是子類別的 show（與 new 的物件有關）
    }
}

// 父類別
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

    public void show()
    {
        System.out.println("車號是" + num);
        System.out.println("汽油量是" + gas);
    }
}

// 子類別（賽車繼承了汽車）
class RacingCar extends Car
{
    private int course;    // 子類別新增的欄位

    public RacingCar()
    {
        course = 0;
        System.out.println("生產了賽車");
    }

    // 子類別新增的方法
    public void setCourse(int c)
    {
        course = c;
        System.out.println("將賽車編號設為" + course);
    }

    // 覆寫父類別的 show 方法
    @Override
    public void show()
    {
        System.out.println("賽車的車號是" + num);
        System.out.println("汽油量是" + gas);
        System.out.println("賽車編號是" + course);
    }
}

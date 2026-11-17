// 投影片 CH4 P4、P5：類別的繼承
public class Sample4_1
{
    public static void main(String[] args)
    {
        RacingCar rccar1;
        rccar1 = new RacingCar();   // 建立子類別的物件

        rccar1.setCar(1234, 20.5);  // 呼叫子類別繼承的方法

        rccar1.setCourse(5);        // 呼叫子類別新增的方法
    }
}

// 父類別
class Car
{
    private int num;
    private double gas;

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
}

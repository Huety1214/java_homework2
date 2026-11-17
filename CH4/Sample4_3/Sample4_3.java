// 投影片 CH4 P9、P10：保護成員 protected
public class Sample4_3
{
    public static void main(String[] args)
    {
        RacingCar rccar1;
        rccar1 = new RacingCar();

        rccar1.newShow();
    }
}

// 父類別
class Car
{
    // 將父類別的成員設為保護成員，子類別可以存取
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

    public void newShow()
    {
        System.out.println("賽車的車號是" + num);   // 子類別可以存取父類別的保護成員
        System.out.println("汽油量是" + gas);
        System.out.println("賽車編號是" + course);
    }
}

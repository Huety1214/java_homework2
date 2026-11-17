// 投影片 CH4 P17、P18：多型（polymorphism）
public class Sample4_6
{
    public static void main(String[] args)
    {
        Car[] cars;
        cars = new Car[2];               // 準備父類別的陣列

        cars[0] = new Car();             // 父類別的物件
        cars[0].setCar(1234, 20.5);

        cars[1] = new RacingCar();       // 子類別的物件
        cars[1].setCar(4567, 30.5);

        // 兩者皆用父類別的陣列操作，show 會依物件實際的類別執行
        for (int i = 0; i < cars.length; i++)
        {
            cars[i].show();
        }
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

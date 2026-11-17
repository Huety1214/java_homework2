// 投影片 CH4 P41、P42：多重繼承（實作多個介面）
public class Sample4_13
{
    public static void main(String[] args)
    {
        Car car1 = new Car(1234, 20.5);
        car1.vShow();
        car1.mShow();
    }
}

// 介面 1
interface iVehicle
{
    void vShow();
}

// 介面 2
interface iMaterial
{
    void mShow();
}

// 類別可以實作兩個以上的介面
class Car implements iVehicle, iMaterial
{
    private int num;
    private double gas;

    public Car(int n, double g)
    {
        num = n;
        gas = g;
        System.out.println("生產了車號為" + num + "，汽油量為" + gas + "的車子");
    }

    // 定義 iVehicle 的方法
    @Override
    public void vShow()
    {
        System.out.println("車號是" + num);
        System.out.println("汽油量是" + gas);
    }

    // 定義 iMaterial 的方法
    @Override
    public void mShow()
    {
        System.out.println("車子的材質是鐵");
    }
}

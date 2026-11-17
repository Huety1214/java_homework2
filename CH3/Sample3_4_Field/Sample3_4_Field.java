// 投影片 CH3 P9：物件的欄位：物件名稱.欄位名稱 與 this.欄位名稱
public class Sample3_4_Field
{
    public static void main(String[] args)
    {
        Car car1;
        car1 = new Car();

        car1.num = 1234;     // 在類別外：物件名稱.欄位名稱
        car1.gas = 20.5;

        car1.show();
        car1.showWithThis();
    }
}

// Car 類別
class Car
{
    int num;
    double gas;

    // 在類別內：直接使用欄位名稱
    void show()
    {
        System.out.println("車號是" + num);
        System.out.println("汽油量是" + gas);
    }

    // 在類別內：前面加上 this. 也合法，結果相同
    void showWithThis()
    {
        System.out.println("車號是" + this.num);
        System.out.println("汽油量是" + this.gas);
    }
}

// 投影片 CH3 P15：一次傳遞多個引數
public class Sample3_7
{
    public static void main(String[] args)
    {
        Car car1;
        car1 = new Car();

        int number = 1234;
        double gasoline = 20.5;

        car1.setNumGas(number, gasoline);   // 傳遞 2 個引數
    }
}

// Car 類別
class Car
{
    int num;
    double gas;

    // 這個方法擁有 2 個參數
    void setNumGas(int n, double g)
    {
        num = n;
        gas = g;
        System.out.println("將車號設為" + num + "，汽油量設為" + gas);
    }

    void show()
    {
        System.out.println("車號是" + num);
        System.out.println("汽油量是" + gas);
    }
}

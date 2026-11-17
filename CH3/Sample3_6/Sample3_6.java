// 投影片 CH3 P14：引數及傳回值：傳遞引數
public class Sample3_6
{
    public static void main(String[] args)
    {
        Car car1;
        car1 = new Car();

        car1.setNum(1234);   // 傳遞引數 1234 呼叫 setNum
        car1.setGas(20.5);   // 傳遞引數 20.5 呼叫 setGas
    }
}

// Car 類別
class Car
{
    int num;
    double gas;

    // 接收 int 型別引數的參數 n
    void setNum(int n)
    {
        num = n;
        System.out.println("將車號設為" + num);
    }

    // 接收 double 型別引數的參數 g
    void setGas(double g)
    {
        gas = g;
        System.out.println("將汽油量設為" + gas);
    }
}

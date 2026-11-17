// 投影片 CH5 P32：拋出例外（改用 throws 交給呼叫者處理）
class Sample5_5
{
    public static void main(String[] args) throws CarException   // 透過 throws 處理例外
    {
        Car car1;
        car1 = new Car();

        car1.setCar(1234, -10.0);   // 這裡就不用加 try ~ catch

        car1.show();
    }
}

class Car
{
    private int num;
    private double gas;

    public Car()
    {
        num = 0;
        gas = 0.0;
        System.out.println("已生產了汽車");
    }

    // 宣告此方法有可能拋出 CarException 例外
    public void setCar(int n, double g) throws CarException
    {
        if (g < 0)
        {
            CarException e = new CarException();
            throw e;          // g 小於零時拋出例外
        } else
        {
            num = n;
            gas = g;
            System.out.println("將車號設為" + num + "，汽油量設為" + gas);
        }
    }

    public void show() {
        System.out.println("車號是" + num);
        System.out.println("汽油量是" + gas);
    }
}

// 繼承 Exception 類別的自定義例外
class CarException extends Exception
{
}

// 投影片 CH5 P14：匯入 import
package pb;
import pc.Car;        // 匯入套件 pc 的 Car 類別

class Sample5_4
{
    public static void main(String[] args)
    {
        Car car1 = new Car();   // 匯入以後就不用加套件名稱
        car1.show();
    }
}

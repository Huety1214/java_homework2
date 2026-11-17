// 投影片 CH3 P16、P17：傳回值（return value）
public class Sample3_8
{
    public static void main(String[] args)
    {
        Car car1;
        car1 = new Car();
        car1.setNumGas(1234, 20.5);

        int number = car1.getNum();         // 呼叫有傳回值的 getNum
        double gasoline = car1.getGas();    // 呼叫有傳回值的 getGas

        System.out.println("調查樣品車時得知");
        System.out.println("車號是" + number + "，汽油量是" + gasoline);
    }
}

// Car 類別
class Car
{
    int num;
    double gas;

    // 有傳回值的方法，傳回型別為 int
    // 語法：傳回值的型態 方法名稱(參數列表) { ... return 運算式; }
    int getNum()
    {
        System.out.println("調查車號");
        return num;
    }

    // 有傳回值的方法，傳回型別為 double
    double getGas()
    {
        System.out.println("調查汽油量");
        return gas;
    }

    // 無傳回值的方法
    void setNumGas(int n, double g)
    {
        num = n;
        gas = g;
        System.out.println("將車號設為" + num + "，汽油量設為" + gas);
    }
}

// 投影片 CH5 P52：同步化：未同步時兩名駕駛同時使用 add 導致錯誤
class Sample6_7
{
    public static void main(String[] args)
    {
        Company cmp = new Company();      // 建立公司物件

        Driver drv1 = new Driver(cmp);    // 建立駕駛物件 1
        drv1.start();

        Driver drv2 = new Driver(cmp);    // 建立駕駛物件 2
        drv2.start();
    }
}

class Company
{
    private int sum = 0;

    public void add(int a) {
        int tmp = sum;
        System.out.println("目前的合計金額是" + tmp + "元");
        System.out.println("賺到" + a + "元了。");
        tmp = tmp + a;
        System.out.println("合計金額是" + tmp + "元");
        sum = tmp;
    }
}

class Driver extends Thread
{
    private Company comp;

    public Driver(Company c) {
        comp = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            comp.add(50);      // 進行匯入金額
        }
    }
}

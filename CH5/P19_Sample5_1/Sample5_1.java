// 投影片 CH5 P19：例外的基礎知識：發生例外
class Sample5_1
{
    public static void main(String[] args)
    {
        int[] test;
        test = new int[5];

        System.out.println("將值指定給test[10]");

        test[10] = 80;     // 超過陣列元素的數量，發生例外
        System.out.println("將80指定給test[10]");   // 發生例外，這兩行不會繼續處理
        System.out.println("順利地執行完畢");
    }
}

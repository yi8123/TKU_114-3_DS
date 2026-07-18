public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount accountA = new BankAccount("A01", "張三", 1000);
        BankAccount accountB = new BankAccount("B02", "李四", 500);

        System.out.println("初始狀態：");
        System.out.println(accountA);
        System.out.println(accountB);
        System.out.println("---------------------------------");

        System.out.println("張三存入 500 元 : " + accountA.deposit(500));
        System.out.println("張三存入 -100 元 : " + accountA.deposit(-100));

        System.out.println("李四提款 200 元 : " + accountB.withdraw(200));
        System.out.println("李四超額提款 1000 元 : " + accountB.withdraw(1000));

        System.out.println("張三轉帳 300 元給李四 : " + accountA.transferTo(accountB, 300));
        
        System.out.println("張三轉帳 5000 元給李四 : " + accountA.transferTo(accountB, 5000));

        System.out.println("---------------------------------");
        System.out.println("最終狀態：");
        System.out.println(accountA);
        System.out.println(accountB);
    }
}